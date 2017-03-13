package com.huihuan.gmp.services.system.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Catalog;
import com.huihuan.gmp.entity.InterfaceModules;
import com.huihuan.gmp.entity.Interfaces;
import com.huihuan.gmp.entity.Module;
import com.huihuan.gmp.entity.Page;
import com.huihuan.gmp.entity.Project;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.system.IModuleService;
import com.huihuan.gmp.vo.ComboboxTreeVo;
import com.huihuan.gmp.vo.ModuleVo;
import com.huihuan.gmp.vo.TreeGridVo;

@Service(value="moduleService")
public class ModuleServiceImpl extends CommServiceImpl implements IModuleService {

	private Log log = LogFactory.getLog(ModuleServiceImpl.class);

	@Override
	public Map getModules(String projectId) throws ServiceException {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		List<Project> list=null;
		if(StringUtil.isEmpty(projectId)){
			list=baseDAO.findByHQL("from Project");
		}else{
			list=baseDAO.findByHQL("from Project where id=?", new Object[]{Long.parseLong(projectId)});
		}
		List returnList=new ArrayList();
		for(Project p : list){
			TreeGridVo vo=new TreeGridVo();
			vo.setId(p.getName());
			vo.setName(p.getName());
			vo.setIconCls("icon-ok");
			returnList.add(vo);
			for(Object o:p.getModules()){
				if(((Module)o).getModule()==null){
					setModuleTree(p.getName(),(Module)o,returnList,0);
				}
			}
		}
		map.put("total", 111);
		map.put("rows", returnList);
		return map;
	}
	
	private void setModuleTree(String pid,Module module,List returnList,int level){
		TreeGridVo vo=new TreeGridVo();
		vo.setId(module.getId()+"");
		vo.setName(module.getName());
		vo.set_parentId(pid);
		if(level==1&&module.getModules().size()>0){
			vo.setState("closed");
		}
		returnList.add(vo);
		for(Object o:module.getModules()){
			setModuleTree(module.getId()+"",(Module)o,returnList,level+1);
		}
	}

	@Override
	public List getModulesForCombobox(String projectId,String interfaceId) throws ServiceException {
		// TODO Auto-generated method stub
		List<ComboboxTreeVo> result=new ArrayList<ComboboxTreeVo>();
		List<Module> list=baseDAO.findByHQL("from Module where project.id="+projectId+" and module=null");
		for(Module module : list){
			ComboboxTreeVo vo = getModuleTreeForCombobox(module,interfaceId);
			result.add(vo);
		}
		return result;
	}
	
	private ComboboxTreeVo getModuleTreeForCombobox(Module module,String interfaceId){
		ComboboxTreeVo vo=new ComboboxTreeVo();
		vo.setId(module.getId()+"");
		vo.setText(module.getName());
		if(module.getModules().size()>0){
			vo.setState("closed");
		}
		for(Object o:module.getModules()){
			ComboboxTreeVo child = getModuleTreeForCombobox((Module)o,interfaceId);
			vo.getChildren().add(child);
		}
		if(!StringUtil.isBlank(interfaceId)){
			int i=baseDAO.getTotalSize("from InterfaceModules where module.id=? and interfaces.id=?", 
					new Object[]{module.getId(),Long.parseLong(interfaceId)});
			if(i>0){
				vo.setChecked(true);
			}
		}
		return vo;
	}

	@Override
	public int deleteModule(String id) throws ServiceException {
		// TODO Auto-generated method stub
		Module module=baseDAO.findById(Long.parseLong(id), Module.class);
		Catalog catalog=baseDAO.findById(Integer.parseInt(id), Catalog.class);
		List<Module> mls=baseDAO.findByProperty("module", module, Module.class);
		if(mls.size()>0){
			for(Module module1:mls){
			     deleteModule(module1.getId().toString());
			}
			
		}
		List<InterfaceModules> list=baseDAO.findByProperty("module", module, InterfaceModules.class);
		System.out.println(list.size());
		if(list.size()>0){
			for(InterfaceModules ifmd:list){
				baseDAO.delete(ifmd);
				Interfaces interf=ifmd.getInterfaces();
//				System.out.println(interf.getName()+";"+interf.getId());
				baseDAO.delete(interf);
				Page page=baseDAO.findById(Integer.parseInt(interf.getId().toString()), Page.class);
				baseDAO.delete(page);
				
			}
		}
		baseDAO.delete(module);
		baseDAO.delete(catalog);
		return 0;
	}

	@Override
	public ModuleVo addModule(String name, String parent)
			throws ServiceException {
		Module module=new Module();
		Catalog catalog=new Catalog();
		module.setName(name);
		catalog.setAddtime((int) (new java.util.Date().getTime()));
		catalog.setCatName(name);
		catalog.setSNumber(99);
		System.out.println(name+";"+parent);
		if(StringUtil.isNumeric(parent)){
			Module pModule=baseDAO.findById(Long.parseLong(parent), Module.class);
			module.setModule(pModule);
			module.setProject(pModule.getProject());
			catalog.setParentCatId(Integer.valueOf(pModule.getId().toString()));
			Catalog parentCatalog=baseDAO.findById(Integer.valueOf(pModule.getId().toString()), Catalog.class);
			catalog.setLevel(parentCatalog.getLevel()+1);
			catalog.setItemId(Integer.valueOf(pModule.getProject().getId().toString()));
		}else{
			Project p=(Project)baseDAO.findByProperty("name", parent, Project.class).get(0);
			module.setProject(p);
			catalog.setItemId(Integer.valueOf(p.getId().toString()));
			catalog.setParentCatId(0);
			catalog.setLevel(2);
		}
		baseDAO.save(module);
		baseDAO.save(catalog);
		ModuleVo vo=new ModuleVo();
		vo.setId(module.getId()+"");
		vo.setName(module.getName());
		return vo;
	}

	@Override
	public int editModule(String id, String name)
			throws ServiceException {
		// TODO Auto-generated method stub
		Module module=baseDAO.findById(Long.parseLong(id), Module.class);
		Catalog catalog=baseDAO.findById(Integer.parseInt(id), Catalog.class);
		module.setName(name);
		catalog.setCatName(name);
		baseDAO.update(module);
		baseDAO.update(catalog);
		return 0;
	}

	@Override
	public ModuleVo getModuleById(String id) throws ServiceException {
		// TODO Auto-generated method stub
		ModuleVo vo=null;
		Module module=baseDAO.findById(Long.parseLong(id), Module.class);
		if(module!=null){
			vo=new ModuleVo();
			vo.setId(module.getId()+"");
			vo.setName(module.getName());
			if(module.getProject()!=null){
				vo.setProject(module.getProject().getName());
			}
		}
		return vo;
	}
}
