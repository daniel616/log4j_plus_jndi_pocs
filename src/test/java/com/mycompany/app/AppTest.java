package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    

    @Test
    public void generalJNDI(){
        System.out.println("Running JNDI test");
        App.jndi();
    }

    @Test
    public void log4j(){
        System.out.println("Running Log4j test")
        App.log4j();
    }

}
