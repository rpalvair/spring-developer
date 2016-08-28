package com.palvair.spring.mvc.form.security.annotations.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.InitializingBean;

import com.palvair.spring.mvc.form.security.annotations.model.User;

import lombok.extern.log4j.Log4j;

@org.aspectj.lang.annotation.Aspect
@Log4j
public class SaveEntityAspect implements InitializingBean {
	@Pointcut("execution(* com.palvair.spring.mvc.form.security.annotations.dao.IDAO.save(..))")
	public void saveEntity() {
	}

	@Before("saveEntity()")
	public void before() {
		log.info("before");
	}

	@After("saveEntity()")
	public void after() {
		log.info("after");
	}

	@Around("saveEntity()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		log.info("around");
		Object[] args =pjp.getArgs();
		
		if(args.length == 1) {
			if(args[0] instanceof User) {
				log.info("saving user "+(User)args[0]);
			}
		}
		pjp.proceed();
	}

	public void afterPropertiesSet() throws Exception {
	
		
	}

}
