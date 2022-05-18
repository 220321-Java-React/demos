package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //This Class is an ASPECT. We will handle all of our Logging functionality here.
//It's so much cleaner to put all of this in one place, which is the point of SpringAOP. Centralizes Cross Cutting Concerns
public class LoggingAspect {

	//a Logger object so that we can do Logging 
	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	//in an Aspect, we have methods called ADVICES. Each advice will be responsible for logging certain parts of the app
	
	//This advice will run some logging BEFORE any method in the models package. 
	//this happens thanks to within() and the name of the package you want to scan 
	//"Before any method within the models package runs, execute this code"
	@Before("within(com.revature.models.*)")
	public void logModelMethods(JoinPoint jp) { //A JoinPoint is where an advice COULD be injected. In this case, models
		
		//getTarget() returns the object getting called, getSignature() returns the method signature
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
		
	}
	
	
	//This advice will run AFTER successfully RETURNING a value 
	//A pointcut is where advice WILL be injected. 
	//In this case, the pointcut is any method called fight() that returns a String. (..) means it can take any params
	//the "returning" attribute is simply giving us access to the object that gets returned from the method.
	@AfterReturning(pointcut="execution(String fight(..))", returning="returnedObject")
	public void logSuccessfulFight(JoinPoint jp, Object returnedObject) {
		//jp is whatever method we're injecting advice into. returnedObject is the object that fight() returns
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
}
