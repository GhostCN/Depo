/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Consultation;
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
public class ConsultationDaoTest {
    
    public ConsultationDaoTest() {
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
     * Test of AddConsultation method, of class ConsultationDao.
     */
    @Before
    public void testAddConsultation() throws Exception {
        System.out.println("AddConsultation");
        Consultation cons = null;
        ConsultationDao instance = new ConsultationDao();
        int expResult = 0;
        int result = instance.AddConsultation(cons);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of GetListConsultation method, of class ConsultationDao.
     */
    @Test
    public void testGetListConsultation() throws Exception {
        System.out.println("GetListConsultation");
        String dos = "";
        ConsultationDao instance = new ConsultationDao();
        List<Consultation> expResult = null;
        List<Consultation> result = instance.GetListConsultation(dos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
