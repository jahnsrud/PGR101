package com.jahnsrud;

import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public ListTest() {
        testMethod();
    }

    public void testMethod() {
        List<String> list = new LinkedList<>();
        populateMethod(list);

        list.stream()
                .filter(s->s.equals("b"))
                .forEach(s->System.out.println(s));

    }

    public void populateMethod(List<String> list) {

        list.add("Hello, World!");
        list.add("a");
        list.add("b");
        list.add("c");
    }
}
