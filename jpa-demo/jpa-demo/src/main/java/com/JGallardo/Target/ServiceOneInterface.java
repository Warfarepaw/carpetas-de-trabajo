package com.JGallardo.Target;

import com.JGallardo.aspect.MyMethodAnnotation;

public interface ServiceOneInterface {

	 void method();
	 void argString(String arg);
	 public void returnInt(int numero);
	 public void exception() throws Exception;
	
	 @MyMethodAnnotation
	 public void annotation();
}
