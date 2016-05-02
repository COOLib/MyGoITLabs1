package ua.goit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.LoggerFactory;

public class LogAspect {

    public void onExecute(ProceedingJoinPoint pjp) throws Throwable {

        org.slf4j.Logger logger = LoggerFactory.getLogger(LogAspect.class);

        logger.info("SLF4J. Before executing of: " + logger.getClass().getName());
      //  System.out.println("SLF4J. Before executing of: " + logger.getClass().getName());

        pjp.proceed();

        logger.info("SLF4J. After executing of: " + logger.getClass().getName());
        //System.out.println("SLF4J. After executing of: " + logger.getClass().getName());
    }

}
