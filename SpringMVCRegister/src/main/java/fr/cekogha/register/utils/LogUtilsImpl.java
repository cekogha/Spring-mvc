package fr.cekogha.register.utils;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Component("logUtils")
public class LogUtilsImpl implements LogUtils {

	/* (non-Javadoc)
	 * @see fr.cekogha.register.utils.LogUtils#printLog_register(org.slf4j.Logger, int, java.lang.Object)
	 * 
	 * #1 : Registration Attempt
	 * #2 : Registration Succeed
	 * #3 : Registration Attempt already tried
	 * #4 : Registration Failed
	 * #5 : Call Registration service
	 * #6 : Result Registration service
	 *  
	 */
	@Override
	public void printLog_register(Logger logger, int numLog, Object object) {
		// TODO Auto-generated method stub
		
		switch(numLog) 
		{
			case 1 :
				logger.info("Registration Attempt : " + object);
				break;
			case 2 :
				logger.info("Registration Succeed : " + object);
				break;
			case 3 :
				logger.warn("Registration Attempt already tried : " + object);
				break;
			case 4 :
				logger.warn("Registration Failed : " + object);
				break;
			case 5 :
				logger.debug("Call Registration service : " + object);
				break;
			case 6 :
				logger.info("Result Registration service : " + object);
				break;
			default :
				logger.warn("Registration Failed : " + object);
				break;
		
		}
		
	}
	
}
