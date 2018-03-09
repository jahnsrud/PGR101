

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MessagePostTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MessagePostTest
{
    private MessagePost messagePost;
    private String username = "Per";
    private String message = "Hello, World!";
    
    /**
     * Default constructor for test class MessagePostTest
     */
    public MessagePostTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        messagePost = new MessagePost(username, message);
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Tester her
     */
    
    @Test
    public void testEqualsDifferentObjectWithSameContent() {
        
        MessagePost otherMessagePost = new MessagePost(username, message);
        boolean answer = messagePost.equals(otherMessagePost);
        assertTrue(answer);
    }
    
}
