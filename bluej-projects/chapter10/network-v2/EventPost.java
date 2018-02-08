
/**
 * Write a description of class EventPost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EventPost extends Post
{
    private String eventMessage;

    /**
     * Constructor for objects of class EventPost
     */
    public EventPost(String author, String eventMessage)
    {
        super(author);
        
        setEventMessage(eventMessage);

    }
    
    public String getEventMessage() {
        return eventMessage;
    }
    
    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }
    
}
