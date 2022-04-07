package in.keepgrowing.interviewcodingquestions.algorithms.search.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchImplementation {

    public Integer findElementIndex(int[] sortedNumbers, int elementValue) {
        int start = 0;
        int end = sortedNumbers.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (sortedNumbers[mid] < elementValue) {
                start = mid + 1;
            } else if (sortedNumbers[mid] > elementValue) {
                end = mid - 1;
            } else if (sortedNumbers[mid] == elementValue) {
                return mid;
            }
        }

        return null;
    }

    /**
     * Java convenience methods
     */
    public Integer findElementIndexWithJavaArrayBinarySearch(int[] sortedNumbers, int elementValue) {
        var index = Arrays.binarySearch(sortedNumbers, elementValue);

        return index >= 0 ? index : null;
    }

    public Integer findElementIndexWithJavaCollectionBinarySearch(List<Integer> sortedNumbers, Integer elementValue) {
        var index = Collections.binarySearch(sortedNumbers, elementValue);

        return index >= 0 ? index : null;
    }
}
