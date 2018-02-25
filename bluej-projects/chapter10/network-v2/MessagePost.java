import java.util.ArrayList;

/**
 * This class stores information about a post in a social network news feed. 
 * The main part of the post consists of a (possibly multi-line)
 * text message. Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class MessagePost extends Post
{
    private String message;  // an arbitrarily long, multi-line message

    /**
     * Constructor for objects of class MessagePost.
     * 
     * @param author    The username of the author of this post.
     * @param text      The text of this post.
     */
    public MessagePost(String author, String text)
    {
        super(author);
        message = text;
    }

    /**
     * Return the text of this post.
     * 
     * @return The post's message text.
     */
    public String getText()
    {
        return message;
    }
    
    public void display() {
        System.out.println(getUsername());
        System.out.println(message);
        System.out.print(getTime());
        System.out.print(getLikes());
        System.out.println(getComments());
    }
    
    /**
     * TODO: Fix
     */
    @Override
    public boolean equals(Object o) {
     
        if (this == o) {
            return true;
        } 
        
        if(!(o instanceof MessagePost)) {
            return false;
        }
        
        if(!super.equals(o)) {
            return false;
        }
        
        MessagePost otherMessagePost = (MessagePost) o;
        if(!this.message.equals(otherMessagePost.message)) {
            return false;
        }
        
        return true;
        
    }
}
