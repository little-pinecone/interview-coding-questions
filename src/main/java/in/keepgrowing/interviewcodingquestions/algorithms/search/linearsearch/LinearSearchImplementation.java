package in.keepgrowing.interviewcodingquestions.algorithms.search.linearsearch;

public class LinearSearchImplementation {

    public Integer findElementIndexWithLinearSearch(int[] numbers, int elementValue) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == elementValue) {
                return i;
            }
        }
        return -1;
    }
}
