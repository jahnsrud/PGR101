
/**
 * Write a description of class Bok here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bok
{
    private String ISBN;
    private String author;
    private String title;
    private String publisher;
    private int inStock;
    
    /**
     * Constructor for objects of class Bok
     */
    public Bok()
    {
        // initialise instance variables
        
    }
    
    public Bok(String ISBN, String author, String title, String publisher, 
    int inStock) {
        
        setISBN(ISBN);
        setAuthor(author);
        setTitle(title);
        setPublisher(publisher);
        setInStock(inStock);
        
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
    public String getISBN() {
        return this.ISBN;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public int getInStock() {
        return inStock;
    }
    
    public void preview() {
        System.out.println("---------");
        System.out.println(getTitle() + " (" + getISBN() + ")");
        System.out.println("Forfatter: " + getAuthor());
        System.out.println("Tittel: " + getTitle());
        System.out.println("Forlag: " + getPublisher());
        System.out.println("Antall inne: " + getInStock());        
        
        System.out.println();
    }
  
}
