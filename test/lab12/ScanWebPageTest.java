/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 3, 2015
 * Time: 2:14:15 PM
 *
 * Project: csci205
 * Package: lab12
 * File: ScanWebPageTest
 * Description:
 *
 * ****************************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ia005
 */
public class ScanWebPageTest {

    public ScanWebPageTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of IllegalException from thegetStream method, of class ScanWebPage.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetStreamI() throws Exception {
        System.out.println("getStream");
        String address = "http:\\www.bucknell.edu";
        BufferedInputStream[] result = new BufferedInputStream[2];
        result = ScanWebPage.getStream(address);

    }

    /**
     * Test of MalformedURLException from getStream method, of class
     * ScanWebPage.
     */
    @Test(expected = MalformedURLException.class)
    public void testGetStreamM() throws Exception {
        System.out.println("getStream");
        String address = "www.bucknell.edu";
        BufferedInputStream[] result = new BufferedInputStream[2];
        result = ScanWebPage.getStream(address);

    }

    /**
     * Test of UnknownHostException from getStream method, of class ScanWebPage.
     */
    @Test(expected = UnknownHostException.class)
    public void testGetStreamU() throws Exception {
        System.out.println("getStream");
        String address = "http://www.bucknell.ed";
        BufferedInputStream[] result = new BufferedInputStream[2];
        result = ScanWebPage.getStream(address);

    }

    /**
     * Test of FileNotFoundException getStream method, of class ScanWebPage.
     */
    @Test(expected = FileNotFoundException.class)
    public void testGetStreamF() throws Exception {
        System.out.println("getStream");
        String address = "http://www.bucknell.edu/blah.html";
        BufferedInputStream[] result = new BufferedInputStream[2];
        result = ScanWebPage.getStream(address);

    }

    /**
     * Test of getStream method, of class ScanWebPage.
     */
    @Test
    public void testGetStream() throws Exception {
        System.out.println("getStream");
        String address = "http://www.bucknell.edu";
        BufferedInputStream[] result = new BufferedInputStream[2];
        result = ScanWebPage.getStream(address);
        assertNotNull(result[0]);
        assertNotNull(result[1]);
    }

}
