package com.JGallardo.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspects {

	@Pointcut("execution(* * (..))")
	public void allMethods() 
	{
		
	}
	
	@Pointcut("execution(public * * (..))")
	public void allPublicMethods() 
	{
		
	}
	
	@Pointcut("execution(* com.JGallardo.Target.*.* (..))")
	public void allMethodsPackage() 
	{
		
	}
	
//	@Pointcut("within(com.JGallardo.Target.*)")
//	public void allMethodsInPackage() 
//	{
//		
//	}
//	
//	@Pointcut("within(com.JGallardo.Target..*)")
//	public void AllMethodsInPackageAndSubPackages() 
//	{
//		
//	}
//	
//	@Before("allPublicMethods()")
//	public void adviceA(JoinPoint p) 
//	{
//		Logger.getLogger("com." + p.getSignature().getName()+"=== Consejo antes de utilizar methodos de un paquete");
//	}
//	
//	@Before("execution(* me* (..))")
//	public void adviceB(JoinPoint p) 
//	{
//		Logger.getLogger("com." + p.getSignature().getName()+"=== Consejo antes de utilizar methodos que empiezan con me.. ");
//	}
//	
//	@Before("whithin(com.JGallardo.aspect.MyClassAnnotation)")
//	public void adviceD(JoinPoint p ) 
//	{
//		Logger.getLogger("com.+"+p.getSignature().getName()+"=== Consejo antes de ejecutar una clase con la anotacion MyClassAnnotation");
//	}
//	
//	@Before("within(com.JGallardo.aspect.MyMethodAnnotation)")
//	public void adviceC(JoinPoint p) 
//	{
//		Logger.getLogger("com."+p.getSignature().getName()+"=== Consejo antes de ejecutar un metodo con la anotacion MyMethodAnnotation");
//	}
	
//	@AfterReturning(pointcut = "allMethodsPackage()", returning = "result")
//	public void adviceF(JoinPoint p, int result) 
//	{
//		Logger.getLogger("com."+p.getSignature().getName()+"=== Consejo despues de ejecutar methodos que provocan una excepcion: return"+ result);
//	}
	
//	@AfterReturning(pointcut = "allMethodsPackage()", returning ="exception")
//	public void adviceG(JoinPoint p, Exception ex)
//	{
//		
//		Logger.getLogger("com."+p.getSignature().getName()+"=== Consejo que se ejecuta despues de que los metodos lancen una excepcion"+ex);
//	}
	
//	@After("execution(* com.JGallardo.Target.ServiceOne.exception())")
//	public void adviceH(JoinPoint p, Exception ex) 
//	{
//		Logger.getLogger("com"+p.getSignature().getName()+"=== Consejo que se ejecuta despues de ejecutar los metodos finally");
//	}
//	
//	@Around("execution(* com.JGallardo.Target.ServiceOne.exception())")
//	public Object adviceM(ProceedingJoinPoint pjp, Exception ex) throws Throwable
//	{
//		Logger.getLogger("com === antes de ........" );
//		Object obj = pjp.proceed();
//		Logger.getLogger("com ==== despes de .......");
//		return obj;
//	}
}
