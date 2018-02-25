import java.util.ArrayList;

/**
 * This class stores information about a news feed post in a 
 * social network. Posts can be stored and displayed. This class
 * serves as a superclass for more specific post types.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class Post 
{
    private String username;  // username of the post's author
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    /**
     * Constructor for objects of class Post.
     * 
     * @param author    The username of the author of this post.
     */
    public Post(String author)
    {
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    public void addComment(String text)
    {
        comments.add(text);
    }

    /**
     * Return the time of creation of this post.
     * 
     * @return The post's creation time, as a system time value.
     */
    protected long getTimeStamp()
    {
        return timestamp;
    }
    
    protected String getUsername() {
        return username;
    }
    
    protected String getComments() {
        
        if(comments.isEmpty()) {
            return "   No comments.";
        }
        else {
            return "   " + comments.size() + " comment(s). Click here to view.";
        }
        
    }
    
    protected String getLikes() {
        
        if(likes > 0) {
            return "  -  " + likes + " people like this.";
        }
        else {
            return "";
        }
        
    }
    
    protected String getTime() {
        return timeString(timestamp);
    }

    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    
    public void display()
    {   
        
       
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder builder = new StringBuilder();
        builder.append(username);
        builder.append("\n");
        builder.append(timeString(timestamp));
        builder.append("\n");
        
        /*
         * 
         *  builder.append("likes");
        builder.append('\n');
        if(likes > 0) {
            builder.append("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            builder.append("   No comments.");
        }
        else {
            builder.append("   " + comments.size() + " comment(s). Click here to view.");
        }
         */
        
        return builder.toString();
        
        
    }
    
    /**
     * Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     * 
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */
    
    protected String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
