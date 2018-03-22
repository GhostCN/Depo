/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Patient;
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
public class PatientDaoTest {
    
    public PatientDaoTest() {
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
     * Test of AddPatient method, of class PatientDao.
     */
    @Test
    public void testAddPatient() throws Exception {
        System.out.println("AddPatient");
        Patient pat = null;
        PatientDao instance = new PatientDao();
        int expResult = 0;
        int result = instance.AddPatient(pat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of NumPatientAuto method, of class PatientDao.
     */
    @Test
    public void testNumPatientAuto() throws Exception {
        System.out.println("NumPatientAuto");
        PatientDao instance = new PatientDao();
        String expResult = "";
        String result = instance.NumPatientAuto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPatient method, of class PatientDao.
     */
    @Test
    public void testGetPatient() throws Exception {
        System.out.println("GetPatient");
        int num = 0;
        PatientDao instance = new PatientDao();
        Patient expResult = null;
        Patient result = instance.GetPatient(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
