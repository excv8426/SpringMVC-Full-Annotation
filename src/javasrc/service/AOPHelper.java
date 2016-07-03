package javasrc.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPHelper {
	
	@Pointcut("execution(* javasrc.service.TestAOP.*(..))")
	public void AOPpoint(){
		System.out.println("run Pointcut");
	}

	@Before("javasrc.service.AOPHelper.AOPpoint()")
	public void before(){
		System.out.println("run before");
	}
	
	@AfterReturning(pointcut="javasrc.service.AOPHelper.AOPpoint()",returning="retVal")
	public void after(Object retVal){
		System.out.println("run after and retVal:"+retVal);
	}
	
	@Around("javasrc.service.AOPHelper.AOPpoint()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("run around");
		Object[] args=pjp.getArgs();
		for (Object object : args) {
			System.out.println("args:"+object);
		}
		return pjp.proceed();
	}
}
