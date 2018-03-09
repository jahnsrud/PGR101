import java.util.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{   
    public Main() {

        testMethod();

    }

    public void testMethod() {
        List<String> list = new LinkedList<>();
        populateMethod(list);

        list.stream().filter(s->s.equals("b")).forEach(s->System.out.println(s));
        


    }

    public void populateMethod(List<String> list) {

        list.add("Hello, World!");
        list.add("a");
        list.add("b");        
        list.add("c");
    }

}
