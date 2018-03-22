/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.RendezVous;
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
public class RendezVousDaoTest {
    
    public RendezVousDaoTest() {
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
     * Test of AddRv method, of class RendezVousDao.
     */
    @Test
    public void testAddRv() throws Exception {
        System.out.println("AddRv");
        RendezVous rv = null;
        RendezVousDao instance = new RendezVousDao();
        int expResult = 0;
        int result = instance.AddRv(rv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListeRV method, of class RendezVousDao.
     */
    @Test
    public void testListeRV() throws Exception {
        System.out.println("ListeRV");
        RendezVousDao instance = new RendezVousDao();
        List<RendezVous> expResult = null;
        List<RendezVous> result = instance.ListeRV();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of NumRvAuto method, of class RendezVousDao.
     */
    @Test
    public void testNumRvAuto() throws Exception {
        System.out.println("NumRvAuto");
        RendezVousDao instance = new RendezVousDao();
        String expResult = "";
        String result = instance.NumRvAuto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
