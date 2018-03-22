/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Dossier;
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
public class DossierDaoTest {
    
    public DossierDaoTest() {
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
     * Test of NumDossier method, of class DossierDao.
     */
    @Test
    public void testNumDossier() throws Exception {
        System.out.println("NumDossier");
        DossierDao instance = new DossierDao();
        String expResult = "";
        String result = instance.NumDossier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SearchDossier method, of class DossierDao.
     */
    @Test
    public void testSearchDossier() throws Exception {
        System.out.println("SearchDossier");
        String num = "";
        DossierDao instance = new DossierDao();
        Dossier expResult = null;
        Dossier result = instance.SearchDossier(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddDossier method, of class DossierDao.
     */
    @Test
    public void testAddDossier() throws Exception {
        System.out.println("AddDossier");
        Dossier d = null;
        DossierDao instance = new DossierDao();
        int expResult = 0;
        int result = instance.AddDossier(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SearchRdv method, of class DossierDao.
     */
    @Test
    public void testSearchRdv() throws Exception {
        System.out.println("SearchRdv");
        String num = "";
        DossierDao instance = new DossierDao();
        List<RendezVous> expResult = null;
        List<RendezVous> result = instance.SearchRdv(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
