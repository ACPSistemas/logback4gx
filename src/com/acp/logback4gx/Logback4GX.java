/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acp.logback4gx;

import ch.qos.logback.classic.Level;
import org.slf4j.MDC;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
import ch.qos.logback.classic.Logger;
import java.util.Vector;
import java.util.Date;

/**
 *
 * @author sebastian
 */
public class Logback4GX {
	public static final String OBJPROPERTY = "L4GXOBJECT";
        public static final String VERSION = "1.2";

	private Logger intLogger;
	private String gxObj;
	private Logback4GXErrorEnum lastError;
	
	public Logback4GX() {
		createIntLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
		setLastError(Logback4GXErrorEnum.NOERROR);
		gxObj = new String();
	}

	public static String getOBJPROPERTY() {
		return OBJPROPERTY;
	}
	
	public static Date getDateFromTimestamp(long timestamp) {
		return new Date(timestamp);
	}	
	
	public static long getTimestampFromDate(Date date) {
		return date.getTime();
	}	
	
	private void createIntLogger(String intLoggerName) {
		intLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(intLoggerName);
	}	

	private void setLastError(Logback4GXErrorEnum lastError) {
		this.lastError = lastError;
	}

	public String getObject() {
		setLastError(Logback4GXErrorEnum.NOERROR);		
		return gxObj;
	}

	public void setObject(String gxObj) {
		setLastError(Logback4GXErrorEnum.NOERROR);		
		this.gxObj = gxObj;
		if (gxObj.length() > 0)
			putProperty(OBJPROPERTY, gxObj);
	}	

	public short setLogger(String name, String gxObject) {
		setObject(gxObject);
		return setLogger(name);
	}
	
	public short setLogger(String name) {
		setLastError(Logback4GXErrorEnum.NOERROR);
		createIntLogger(name);
		return getLastErrorCode();
	}
	
	public String getLoggerName() {
		setLastError(Logback4GXErrorEnum.NOERROR);
		return intLogger.getName();
	}	
	
//	public void setLogger(Logger logger) {
//		setLastError(Logback4GXErrorEnum.NOERROR);		
//		intLogger = logger;
//	}	
	
	public Logger getLogger() {
		setLastError(Logback4GXErrorEnum.NOERROR);
		return intLogger;
	}
	
	public String setLevel(String level) {
		setLastError(Logback4GXErrorEnum.NOERROR);
		intLogger.setLevel(Level.toLevel(level, Level.DEBUG));
		return getLevel();
	}
	
	public String getLevel() {
		setLastError(Logback4GXErrorEnum.NOERROR);
		return intLogger.getEffectiveLevel().toString();
	}
	
	public short putProperty(String key, String value) {
		setLastError(Logback4GXErrorEnum.NOERROR);
		MDC.put(key, value);
		return getLastErrorCode();		
	}
	
	public short removeProperty(String key) {
		setLastError(Logback4GXErrorEnum.NOERROR);
		MDC.remove(key);
		return getLastErrorCode();		
	}
	
	public short clearProperties() {
		setLastError(Logback4GXErrorEnum.NOERROR);
		MDC.clear();
		return getLastErrorCode();
	}
	
	public short getLastErrorCode() {
		return lastError.getCode();
	}
	
	public String getLastErrorDesc() {
		return lastError.getDescription();
	}
	
	public void debug(String text) {
		intLogger.debug(text);
	}
	
	public void debug(String text, Object arg0) {
		intLogger.debug(text, arg0);
	}	
	
	public void debug(String text, Object arg0, Object arg1) {
		intLogger.debug(text, arg0, arg1);
	}
        
	public void debug(String text, Object arg0, Object arg1, Object arg2 ) {
		intLogger.debug(text, new Object[] {arg0,arg1,arg2} );
	}        
        
	public void debug(String text, Object arg0, Object arg1, Object arg2, Object arg3 ) {
		intLogger.debug(text, new Object[] {arg0,arg1,arg2,arg3} );
	}          
	
	public void debug(String text, Vector<Object> collection) {
		intLogger.debug(text, collection.toArray());
	}	
	
	public void trace(String text) {
		intLogger.trace(text);
	}
	
	public void trace(String text, Object arg0) {
		intLogger.trace(text, arg0);
	}	
	
	public void trace(String text, Object arg0, Object arg1) {
		intLogger.trace(text, arg0, arg1);
	}
	
      	public void trace(String text, Object arg0, Object arg1, Object arg2 ) {
		intLogger.trace(text, new Object[] {arg0,arg1,arg2} );
	}        
        
	public void trace(String text, Object arg0, Object arg1, Object arg2, Object arg3 ) {
		intLogger.trace(text, new Object[] {arg0,arg1,arg2,arg3} );
	}  
        
	public void trace(String text, Vector<Object> collection) {
		intLogger.trace(text, collection.toArray());
	}
	
	public void info(String text) {
		intLogger.info(text);
	}
	
	public void info(String text, Object arg0) {
		intLogger.info(text, arg0);
	}	
	
	public void info(String text, Object arg0, Object arg1) {
		intLogger.info(text, arg0, arg1);
	}
        
      	public void info(String text, Object arg0, Object arg1, Object arg2 ) {
		intLogger.info(text, new Object[] {arg0,arg1,arg2} );
	}        
        
	public void info(String text, Object arg0, Object arg1, Object arg2, Object arg3 ) {
		intLogger.info(text, new Object[] {arg0,arg1,arg2,arg3} );
	}         
	
	public void info(String text, Vector<Object> collection) {
		intLogger.info(text, collection.toArray());
	}
	
	public void warn(String text) {
		intLogger.warn(text);
	}
	
	public void warn(String text, Object arg0) {
		intLogger.warn(text, arg0);
	}	
	
	public void warn(String text, Object arg0, Object arg1) {
		intLogger.warn(text, arg0, arg1);
	}

        public void warn(String text, Object arg0, Object arg1, Object arg2 ) {
		intLogger.warn(text, new Object[] {arg0,arg1,arg2} );
	}        
        
	public void warn(String text, Object arg0, Object arg1, Object arg2, Object arg3 ) {
		intLogger.warn(text, new Object[] {arg0,arg1,arg2,arg3} );
	}     
        
	public void warn(String text, Vector<Object> collection) {
		intLogger.warn(text, collection.toArray());
	}	
	
	public void error(String text) {
		intLogger.error(text);
	}
	
	public void error(String text, Object arg0) {
		intLogger.error(text, arg0);
	}	
	
	public void error(String text, Object arg0, Object arg1) {
		intLogger.error(text, arg0, arg1);
	}

        public void error(String text, Object arg0, Object arg1, Object arg2 ) {
		intLogger.error(text, new Object[] {arg0,arg1,arg2} );
	}        
        
	public void error(String text, Object arg0, Object arg1, Object arg2, Object arg3 ) {
		intLogger.error(text, new Object[] {arg0,arg1,arg2,arg3} );
	}           
	
	public void error(String text, Vector<Object> collection) {
		intLogger.error(text, collection.toArray());
	}
		
        public static String getVERSION() {
            return VERSION;
        }	
}
