
/**
 * Write a description of class TryktBok here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TryktBok extends Bok
{
    private int pages;
    private int numberOfCopies;
    
    public TryktBok(String ISBN, String author, String title, String publisher, 
    int inStock, int pages, int numberOfCopies)
    {
        super(ISBN, author, title, publisher, inStock);
        setPages(pages);
        setNumberOfCopies(numberOfCopies);
        
    }
    
    public void setPages(int pages) {
        this.pages = pages;
    }
    
    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
    
    public int getPages() {
        return pages;
    }
    
    public int getNumberOfCopies() {
        return numberOfCopies;
    }
    
    public void preview() {
            
        super.preview();
        
        System.out.println("Dette er en trykt bok :)");
        System.out.println("Boken er på " + getPages() + " sider");
        System.out.println("Antall kopier: " + getNumberOfCopies()); 
        System.out.println();
       
        
    }

}
