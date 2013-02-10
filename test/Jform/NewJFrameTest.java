/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jform;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Димитрий
 */
public class NewJFrameTest {

    public NewJFrameTest() {
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
     * Test of selectFile method, of class NewJFrame.
     */
    @Test
    public void testSelectFile() {
        System.out.println("selectFile");
        NewJFrame instance = new NewJFrame();
        File expResult = null;
        File result = instance.selectFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class NewJFrame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        NewJFrame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testProcessString() {
        System.out.println("main");
        NewJFrame instance = new NewJFrame();        
        instance.dict.add("a");
        instance.dict.add("strong");
        instance.dict.add("kill");
        instance.dict.add("b");
        String res = "from <b>a</b> to stronger <b>kill</b> and <b>b</b> <b>b</b> <b>b</b> ";        
        String resExperim = instance.processOneString("from a to stronger kill and b b b ");

// TODO review the generated test code and remove the default call to fail.
        assertEquals(res, resExperim);
    }
}
