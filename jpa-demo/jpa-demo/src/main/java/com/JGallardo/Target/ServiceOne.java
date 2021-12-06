package com.JGallardo.Target;


import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import com.JGallardo.aspect.MyClassAnnotation;
import com.JGallardo.aspect.MyMethodAnnotation;


@Service
@MyClassAnnotation
public class ServiceOne implements ServiceOneInterface{

	
	public void method() 
	{
		Logger.getLogger("com").debug("----------> ServiceOne:Method");
	}
	
	public void argString(String arg) 
	{
		Logger.getLogger("com").debug("--------> ServiceOne:argOneString(name: "+ arg +")");
		System.out.println("--------> ServiceOne:argOneString(name: "+ arg +")");
	} 
	
	public void returnInt(int numero) 
	{
		Logger.getLogger("com").debug("--------> ServiceOne:returnInt return="+numero+"");
	}
	
	public void exception() throws Exception
	{
		Logger.getLogger("com").debug("----->ServiceOne:Exception:");
		throw new Exception(">:c");
	}
	
	@MyMethodAnnotation
	public void annotation() 
	{
		Logger.getLogger("com").debug("----->ServiceOne:Exception");
		
	}
}
