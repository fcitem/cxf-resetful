package com.message.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**统一异常拦截记录日志
 * @author fengchao
 * @data 2017年7月13日
 */
@Aspect
@Component
public class ExceptionIntercept {

	LoggerUtil log=LoggerUtil.getLogger(this.getClass());
	/**
	 * @author fengchao
	 * @data 2016-10-17
	 * @注释：任何com.message包下面的方法将被aop拦截
	 */
	@Pointcut("execution(* com.message..*.*(..))")
	public void exceptionPoint(){}
	/**
	 * @author fengchao
	 * @data: 2016年10月2日
	 * @注释：判断是否出现异常，记录日志
	 */
	@AfterThrowing(pointcut="exceptionPoint()",throwing="exception")
	public void exceptionLog(JoinPoint joinPoint,Throwable exception){
		log.error(exception);
	}
}
