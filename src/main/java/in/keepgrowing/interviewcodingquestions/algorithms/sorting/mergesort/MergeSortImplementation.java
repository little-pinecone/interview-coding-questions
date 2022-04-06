package in.keepgrowing.interviewcodingquestions.algorithms.sorting.mergesort;

import java.util.Arrays;

public class MergeSortImplementation {

    public int[] sortWithMergeSort(int[] numbers) {
        if (numbers.length == 0 || numbers.length == 1) {
            return numbers;
        }
        int mid = Math.floorDiv(numbers.length, 2);
        int[] left = Arrays.copyOfRange(numbers, 0, mid);
        int[] right = Arrays.copyOfRange(numbers, mid, numbers.length);

        int[] leftSorted = sortWithMergeSort(left);
        int[] rightSorted = sortWithMergeSort(right);

        return merge(leftSorted, rightSorted);
    }

    private int[] merge(int[] left, int[] right) {
        int[] sorted = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int sortedIndex = 0;
        while (unprocessedElementsInBothArrays(left.length, right.length, leftIndex, rightIndex)) {
            int min;
            if (shouldTakeElementFromLeft(left[leftIndex], right[rightIndex])) {
                min = left[leftIndex];
                leftIndex++;
            } else {
                min = right[rightIndex];
                rightIndex++;
            }
            sorted[sortedIndex] = min;
            sortedIndex++;
        }
        if (allFromLeftProcessed(left, leftIndex)) {
            while (rightIndex < right.length) {
                sorted[sortedIndex] = right[rightIndex];
                sortedIndex++;
                rightIndex++;
            }
        }
        if (allFromRightProcessed(right, rightIndex)) {
            while (leftIndex < left.length) {
                sorted[sortedIndex] = left[leftIndex];
                sortedIndex++;
                leftIndex++;
            }
        }

        return sorted;
    }

    private boolean unprocessedElementsInBothArrays(int leftSize, int rightSize, int leftIndex, int rightIndex) {
        return leftIndex < leftSize && rightIndex < rightSize;
    }

    private boolean shouldTakeElementFromLeft(int left, int right) {
        return left < right;
    }

    private boolean allFromLeftProcessed(int[] left, int leftIndex) {
        return leftIndex == left.length;
    }

    private boolean allFromRightProcessed(int[] right, int rightIndex) {
        return rightIndex == right.length;
    }
}
