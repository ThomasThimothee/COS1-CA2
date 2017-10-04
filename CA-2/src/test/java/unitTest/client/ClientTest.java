/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTest.client;

import client.Client;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import server.Server;

/**
 *
 * @author thomasthimothee
 */
public class ClientTest {
    
    public ClientTest() {
        Server s = new Server();
        s.setIP("localhost");
        s.setPort(1234);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of run method, of class Client.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Client instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class Client.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        Client instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListClients method, of class Client.
     */
    @Test
    public void testGetListClients() {
        System.out.println("getListClients");
        Client instance = null;
        Map<String, Client> expResult = null;
        Map<String, Client> result = instance.getListClients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Client.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Client instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Client.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Client instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOut method, of class Client.
     */
    @Test
    public void testGetOut() {
        System.out.println("getOut");
        Client instance = null;
        PrintWriter expResult = null;
        PrintWriter result = instance.getOut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIn method, of class Client.
     */
    @Test
    public void testGetIn() {
        System.out.println("getIn");
        Client instance = null;
        Scanner expResult = null;
        Scanner result = instance.getIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
