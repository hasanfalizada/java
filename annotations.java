package main;

import java.lang.annotation.Annotation;

@Deprecated
public class Annotations {
    public static void main(String[] args) {
        Class<Annotations> anns = Annotations.class;
        Annotation[] allAnns = anns.getAnnotations();
        System.out.println("Annotations count: " + allAnns.length);

        for (Annotation ann : allAnns) {
            System.out.println(ann.toString());
        }
    }
}
