package com.message.util;

import org.apache.log4j.Logger;

/**
 * @author fengchao
 * @data 2017年6月9日
 * @注释 日志记录util
 */
public class LoggerUtil {
	private Logger log=Logger.getLogger(LoggerUtil.class);
	
	/**
	 * @author fengchao
	 * @data 2017年6月9日
	 * @注释 记录debugger日志类型
	 * 注意判断是否开启debugger开关
	 */
	public void debugger(String msg){
		if(log.isDebugEnabled()){
			log.debug(msg);
		}
	}
	public void info(String msg){
		if(log.isInfoEnabled()){
			log.info(msg);
		}
		
	}
	public void error(Object msg){
		log.error("异常:",(Throwable) msg);
	}
	public static <T> LoggerUtil getLogger(T objClass){
		LoggerUtil util=new LoggerUtil();
		util.log=Logger.getLogger(objClass.getClass());
		return util;
	}

}
