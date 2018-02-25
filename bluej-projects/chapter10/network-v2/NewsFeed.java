import java.util.ArrayList;

/**
 * The NewsFeed class stores news posts for the news feed in a
 * social network application.
 * 
 * Display of the posts is currently simulated by printing the
 * details to the terminal. (Later, this should display in a browser.)
 * 
 * This version does not save the data to disk, and it does not
 * provide any search or ordering functions.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class NewsFeed
{
    private ArrayList<Post> posts;

    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        posts = new ArrayList<>();
    }

    public void populateNewsFeed() {

        MessagePost m1 = new MessagePost("@jahnsrud", "Høyskolen Kristiania :o");
        MessagePost m2 = new MessagePost("@jahmar17", "PGR101 oh yeah");

        PhotoPost p1 = new PhotoPost("@jahnsrud", "fintbilde.jpg", "Kult!");
        PhotoPost p2 = new PhotoPost("@jahmar17", "farlig.png", "heeey");

        addPost(m1);
        addPost(m2);        
        addPost(p1);
        addPost(p2);      

    }

    /**
     * Add a post to the news feed.
     * 
     * @param post  The post to be added.
     */
    public void addPost(Post post)
    {
        posts.add(post);
    }

    /**
     * Show the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show()
    {
        // display all posts
        for(Post post : posts) {
            post.display();
            System.out.println();   // empty line between posts
        }
        
    }
    
    public void showAllMessagePosts() {
        
       for(Post post : posts) {
            if (post instanceof MessagePost) {
                post.display();
                System.out.println();
            } else {
                System.out.println("Ignoring...");
            }
        }   
        
    }
    
    public void showAllPhotoPosts() {

        for(Post post : posts) {
            if (post instanceof PhotoPost) {
                post.display();
                System.out.println();
            } else {
                System.out.println("Ignoring...");
            }
        }

    }
}
