package in.keepgrowing.interviewcodingquestions.other.heappollution;

import java.util.Set;
import java.util.TreeSet;

public class HeapPollutionExample {

    public void runDemo() {
        Set originalSet = new TreeSet<Integer>(); // Raw use of parameterized class Set
        Set<String> copy = originalSet; //Unchecked assignment: 'java.util.Set' to 'java.util.Set<java.lang.String>'
        originalSet.add(1); //Unchecked call to 'add(E)' as a member of raw type 'java.util.Set'

        copy.forEach(System.out::println); // ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    }
}
