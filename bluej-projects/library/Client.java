import java.util.*;
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client
{
    private ArrayList<Bok> books;
    
    /**
     * Constructor for objects of class Client
     */
    public Client()
    {
        // initialise instance variables
        books = new ArrayList();
        
    }
    
    public void mainMethod() {
        
        Bok bt1 = new TryktBok("12345", "Joseph Heller", "Cath 22", "Penguin", 10, 125, 5);
        Bok bt2 = new TryktBok("77777", "Linn Ullmann", "Før du sovner", "Oktober", 5, 319, 10);
        
        Bok bl1 = new Lydbok("23456", "Heide Linde", "Norsk sokkel", "Gyldendal", 15, 432, 3, "Petter Northug");
        
        addBook(bt1);
        addBook(bt2);
        addBook(bl1);
        
        for (Bok book : books) {
            book.preview();
            
            if (book instanceof Lydbok) {
                // System.out.println("Lydbok");
            } else if (book instanceof TryktBok) {
                // System.out.println("Trykt bok");
            }
        }
        
    }
    
    public void addBook(Bok book) {
        books.add(book);
    }

    
}
