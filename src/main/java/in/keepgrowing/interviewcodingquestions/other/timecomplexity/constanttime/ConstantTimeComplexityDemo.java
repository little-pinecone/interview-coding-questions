package in.keepgrowing.interviewcodingquestions.other.timecomplexity.constanttime;

import java.util.*;

public class ConstantTimeComplexityDemo {

    public int sumArithmeticSeries(int firstNumber, int commonDifference, int terms) {
        return ((terms / 2) * (2 * firstNumber + (terms - 1) * commonDifference));
    }

    public List<Integer> changeLinkedListContent() {
        List<Integer> numbers = new LinkedList<>();
        Integer element = 1;

        numbers.add(element);
        numbers.remove(element);

        return numbers;
    }

    public String getElementFromArrayList() {
        List<String> phrases = new ArrayList<>();
        phrases.add("first");

        return phrases.get(0);
    }

    public int getLengthOfArray() {
        int[] numbers = {1, 2, 3};

        return numbers.length;
    }

    public void printNumber() {
        int number = 100_000;

        System.out.println(number);
    }

    public Set<Integer> operateOnSet() {
        Set<Integer> numbers = new HashSet<>(); // also for LinkedHashSet, EnumSet
        int element = 1;

        numbers.add(element);
        numbers.contains(element);
        numbers.remove(element);

        return numbers;

    }

    public Map<String, String> checkMapContent() {
        Map<String, String> dictionary = Map.of("term", "definition"); // for HashMap, LinkedHashMap, EnumMap

        dictionary.get("term");
        dictionary.containsKey("term");

        return dictionary;
    }

    public Queue<Integer> operateOnQueue() {
        Queue<Integer> numbers = new ArrayDeque<>();
        numbers.add(1);

        Integer headPeek = numbers.peek();
        Integer headRemoved = numbers.poll();

        return numbers;
    }
}
