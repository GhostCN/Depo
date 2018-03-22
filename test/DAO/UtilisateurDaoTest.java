/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Utilisateur;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ghost CN
 */
public class UtilisateurDaoTest {
    
    public UtilisateurDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetUser method, of class UtilisateurDao.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("GetUser");
        String log = "";
        String passwd = "";
        UtilisateurDao instance = new UtilisateurDao();
        Utilisateur expResult = null;
        Utilisateur result = instance.GetUser(log, passwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UtilisateurDao.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        Utilisateur user = null;
        UtilisateurDao instance = new UtilisateurDao();
        int expResult = 0;
        int result = instance.addUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListeU method, of class UtilisateurDao.
     */
    @Test
    public void testListeU() throws Exception {
        System.out.println("ListeU");
        UtilisateurDao instance = new UtilisateurDao();
        List<Utilisateur> expResult = null;
        List<Utilisateur> result = instance.ListeU();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of NumUserAuto method, of class UtilisateurDao.
     */
    @Test
    public void testNumUserAuto() throws Exception {
        System.out.println("NumUserAuto");
        UtilisateurDao instance = new UtilisateurDao();
        String expResult = "";
        String result = instance.NumUserAuto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
