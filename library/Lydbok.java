
/**
 * Write a description of class Lydbok here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lydbok extends Bok
{
    private int durationInMinutes;
    private int numberOfDiscs;
    private String narrator;
    
    public Lydbok(String ISBN, String author, String title, String publisher, 
    int inStock, int durationInMinutes, int numberOfDiscs, String narrator)
    {
        super(ISBN, author, title, publisher, inStock);
        
        setDurationInMinutes(durationInMinutes);
        setNumberOfDiscs(numberOfDiscs);
        setNarrator(narrator);
        
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
    
    public void setNumberOfDiscs(int numberOfDiscs) {
        this.numberOfDiscs = numberOfDiscs;
    }
    
    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }
    
    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    
    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }
    
    public String getNarrator() {
        return narrator;
    }
    
    public void preview() {
            
        super.preview();
        
        System.out.println("Dette er en lydbok :) Den er lest av " + getNarrator());
        System.out.println("Lengde: " + getDurationInMinutes() + " minutter");
        System.out.println("Antall disker: " + getNumberOfDiscs());
        System.out.println();
       
        
    }
 
}
