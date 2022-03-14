package com.dmsApi.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Shivam Rai
 * Created Date : 08/03/2022
 *
 */

public class Logs {

	
	    //Initialize Log4j instance
	    private static Logger Log =  LogManager.getLogger(Logs.class);

	    //Info Level Logs
	    public static void info (String message) {
	        Log.info(message);
	    }

	    //Warn Level Logs
	    public static void warn (String message) {
	        Log.warn(message);
	    }

	    //Error Level Logs
	    public static void error (String message) {
	        Log.error(message);
	    }

	    //Fatal Level Logs
	    public static void fatal (String message) {
	        Log.fatal(message);
	    }

	    //Debug Level Logs
	    public static void debug (String message) {
	        Log.debug(message);
	    }
	}

