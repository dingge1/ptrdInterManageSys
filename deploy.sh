#!/bin/sh
#to deploy PTRD App Version 2.1.3.0
#copyright to SAPTAC

export PTRDVERSION=V2.1.3.0

export POSTRADFILENAME=postrade.zip
export IMIXFILENAME=IMIXAgent.zip
export CREATEPATH=deploy_$PTRDVERSION

export DEPLOY=/home/ptd/app
export DEPLOYHOME=/home/ptd/var/$PTRDVERSION/app
export DATE=$(date '+%Y%m')
echo $DATE

cd $DEPLOYHOME
echo "开始升级部署" >> $DEPLOYHOME/$CREATEPATH.log
echo "升级至版本 "$PTRDVERSION >> $DEPLOYHOME/$CREATEPATH.log

if [ ! -d $CREATEPATH ]; then
	echo "创建备份目录" >> $DEPLOYHOME/$CREATEPATH.log
	mkdir $CREATEPATH
	cd $CREATEPATH
else
	echo "备份目录已经存在" >> $DEPLOYHOME/$CREATEPATH.log
	cd $CREATEPATH
	rm -rf *
fi

#部署Postrade
echo "开始升级postrade" >> $DEPLOYHOME/$CREATEPATH.log
if [ -f "$DEPLOYHOME/$POSTRADFILENAME" ]; then
	unzip -o $DEPLOYHOME/$POSTRADFILENAME
	if [ -d "$DEPLOY/postrade/" ]; then
		#备份
		echo "备份postrade" >> $DEPLOYHOME/$CREATEPATH.log
		tar -zcvf postrade_bak_$DATE.tar.gz $DEPLOY/postrade/
		cp -rf $DEPLOY/postrade/WEB-INF/classes/resources/ postrade_config/
		#删除旧文件
		echo "删除旧文件" >> $DEPLOYHOME/$CREATEPATH.log
	    rm -rf $DEPLOY/postrade/WEB-INF/lib/*
		
		#升级
		echo "升级postrade" >> $DEPLOYHOME/$CREATEPATH.log
		cp -rf postrade $DEPLOY
		
		#恢复配置
		echo "恢复postrade环境参数" >> $DEPLOYHOME/$CREATEPATH.log
		cp -rf postrade_config/ehcache/ehcache.xml $DEPLOY/postrade/WEB-INF/classes/resources/ehcache/ehcache.xml
		cp -rf postrade_config/filesync/sftpFile.properties $DEPLOY/postrade/WEB-INF/classes/resources/filesync/sftpFile.properties
		cp -rf postrade_config/hibernate/hibernate.properties $DEPLOY/postrade/WEB-INF/classes/resources/hibernate/hibernate.properties
		cp -rf postrade_config/log4j/log4j.properties $DEPLOY/postrade/WEB-INF/classes/resources/log4j/log4j.properties
		cp -rf postrade_config/rmi/applicationContext_rmiClientInfo.xml $DEPLOY/postrade/WEB-INF/classes/resources/rmi/applicationContext_rmiClientInfo.xml
		cp -rf postrade_config/rmi/applicationContext_rmiPolicy.xml $DEPLOY/postrade/WEB-INF/classes/resources/rmi/applicationContext_rmiPolicy.xml
		cp -rf postrade_config/spring/applicationContext-SysInfo.xml $DEPLOY/postrade/WEB-INF/classes/resources/spring/applicationContext-SysInfo.xml
		
		cp -rf postrade_config/security/key1.properties $DEPLOY/postrade/WEB-INF/classes/resources/security/key1.properties
		cp -rf postrade_config/security/key2.properties $DEPLOY/postrade/WEB-INF/classes/resources/security/key2.properties
		cp -rf postrade_config/security/key3.properties $DEPLOY/postrade/WEB-INF/classes/resources/security/key3.properties
			
		#恢复debug控制文件
		echo "恢复postrade环境参数" >> $DEPLOYHOME/$CREATEPATH.log
		if [ -f postrade_config/debug.properties ]; then 
 		   touch $DEPLOY/postrade/WEB-INF/classes/resources/debug.properties
		fi
	else
		#不存在，报警
		echo "未安装过postrade，中止升级" >> $DEPLOYHOME/$CREATEPATH.log
	fi
	rm -rf postrade
	chmod 755 $DEPLOY/postrade/WEB-INF/*.sh
	echo "升级postrade结束" >> $DEPLOYHOME/$CREATEPATH.log
	#清除Weblogic缓存
	rm -rf /home/bea/wldomains/Applicationdomain/post_trade_domain/servers/Ptrd1/tmp/_WL_user/postrade
	rm -rf /home/bea/wldomains/Applicationdomain/post_trade_domain/servers/Ptrd2/tmp/_WL_user/postrade
	echo "清除Weblogic缓存完成" >> $DEPLOYHOME/$CREATEPATH.log
else
	echo "$POSTRADFILENAME升级文件不存在" >> $DEPLOYHOME/$CREATEPATH.log
fi

#部署IMIXAgent
echo "开始升级IMIXAgent" >> $DEPLOYHOME/$CREATEPATH.log
if [ -f "$DEPLOYHOME/$IMIXFILENAME" ]; then
	unzip -o $DEPLOYHOME/$IMIXFILENAME
	if [ -d "$DEPLOY/IMIXAgent/" ]; then
		#备份
		echo "备份IMIXAgent" >> $DEPLOYHOME/$CREATEPATH.log
		tar -zcvf IMIXAgent_bak_$DATE.tar.gz $DEPLOY/IMIXAgent/
		cp -rf $DEPLOY/IMIXAgent/bin/resources IMIXAgent_config/
		#删除旧文件
		echo "删除旧文件" >> $DEPLOYHOME/$CREATEPATH.log
	  rm -rf $DEPLOY/IMIXAgent/lib/*
		
		
		#升级
		echo "升级IMIXAgent" >> $DEPLOYHOME/$CREATEPATH.log
		cp -rf IMIXAgent/bin $DEPLOY/IMIXAgent
	  cp -rf IMIXAgent/lib $DEPLOY/IMIXAgent
	  cp -rf IMIXAgent/start.sh $DEPLOY/IMIXAgent/start.sh
	  cp -rf IMIXAgent/stop.sh $DEPLOY/IMIXAgent/stop.sh
	  
	  #恢复配置
		echo "恢复IMIXAgent环境参数" >> $DEPLOYHOME/$CREATEPATH.log
		cp -rf IMIXAgent_config/hibernate/hibernate.properties $DEPLOY/IMIXAgent/bin/resources/hibernate/hibernate.properties
		cp -rf IMIXAgent_config/imix/ptrd.xml $DEPLOY/IMIXAgent/bin/resources/imix/ptrd.xml
		cp -rf IMIXAgent_config/log4j/log4j.properties $DEPLOY/IMIXAgent/bin/resources/log4j/log4j.properties
		cp -rf IMIXAgent_config/spring/applicationContext_rmiClientInfo.xml $DEPLOY/IMIXAgent/bin/resources/spring/applicationContext_rmiClientInfo.xml
		cp -rf IMIXAgent_config/spring/applicationContext_rmiPolicy.xml $DEPLOY/IMIXAgent/bin/resources/spring/applicationContext_rmiPolicy.xml
			  
	else
		#不存在，报警
		echo "未安装过IMIXAgent，中止升级" >> $DEPLOYHOME/$CREATEPATH.log
	fi
	rm -rf IMIXAgent
	chmod 755 $DEPLOY/IMIXAgent/*.sh
	echo "升级IMIXAgent结束" >> $DEPLOYHOME/$CREATEPATH.log
else
	echo "$IMIXFILENAME升级文件不存在" >> $DEPLOYHOME/$CREATEPATH.log
fi

echo "开始产生回退脚本" >> $DEPLOYHOME/$CREATEPATH.log
echo "#!/bin/sh" > $DEPLOYHOME/rollback.sh
echo "#to rollback PTRD App Version $PTRDVERSION" >> $DEPLOYHOME/rollback.sh
echo "#copyright to SAPTAC" >> $DEPLOYHOME/rollback.sh
echo "" >> $DEPLOYHOME/rollback.sh
echo "cd $DEPLOYHOME/$CREATEPATH" >> $DEPLOYHOME/rollback.sh
echo "tar -zxvf postrade_bak_$DATE.tar.gz" >> $DEPLOYHOME/rollback.sh
echo "tar -zxvf IMIXAgent_bak_$DATE.tar.gz" >> $DEPLOYHOME/rollback.sh
echo "rm -rf $DEPLOY/postrade/" >> $DEPLOYHOME/rollback.sh
echo "rm -rf $DEPLOY/IMIXAgent" >> $DEPLOYHOME/rollback.sh
echo "cp -rf home/ptd/app/postrade $DEPLOY" >> $DEPLOYHOME/rollback.sh
echo "cp -rf home/ptd/app/IMIXAgent $DEPLOY" >> $DEPLOYHOME/rollback.sh
echo "回退脚本创建完成" >> $DEPLOYHOME/$CREATEPATH.log

chmod 755 $DEPLOYHOME/rollback.sh
