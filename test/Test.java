/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.acp.logback4gx.*;
import ch.qos.logback.classic.Level;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;


/**
 *
 * @author sebastian
 */
public class Test {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	
//		MDC.put("RUTINA", "45");
//		
//		Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Test.class);
//		logger.setLevel(Level.ALL);
//		logger.debug("Hello world!");
//	
//		int algo = 80;
//		int zero = 0;
//		
//		try {
//			float result = algo/zero;
//		} catch(Exception e) {
//			logger.debug("burro no se puede dividir por cero", e);
//		}

		Logback4GX log = new Logback4GX();
		
		log.setLevel("TRACE");
		
		log.setLogger("unLogger","unObjeto");		
		
		//System.out.println(log.setLevel("INFO"));
		System.out.println(log.getLoggerName() + ":" + log.getLevel());
		
//		log.putProperty("nombre", "sebastian");
		
		log.debug("Hola {}", "otro mundo");
                log.debug("Hola version {} y otros {} {} {}", Logback4GX.getVERSION(),1,"pedro");
                //log.debug("User {}", GxPropertyReader.getGxDataStoreUser());
//		long ts = 1340027230209l;
//		System.out.println(Logback4GX.getDateFromTimestamp(ts));
		
//		Logger logger = log.getLogger();
		
//		logger.debug("prueba directa");

//		log.trace("un trace {} raro ", Logback4GX.OBJPROPERTY);
//		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//		StatusPrinter.print(lc);

		
	}
}
