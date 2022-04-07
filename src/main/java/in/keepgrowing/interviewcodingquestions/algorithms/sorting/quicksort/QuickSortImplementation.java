package in.keepgrowing.interviewcodingquestions.algorithms.sorting.quicksort;

public class QuickSortImplementation {

    public int[] sortWithLastElementAsPivot(int[] numbers, int start, int end) {
        if (start < end) {
            int pivotIndex = partitionWhenPivotLast(numbers, start, end);

            sortWithLastElementAsPivot(numbers, start, pivotIndex - 1);
            sortWithLastElementAsPivot(numbers, pivotIndex + 1, end);
        }
        return numbers;
    }

    private int partitionWhenPivotLast(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int leftIndex = start - 1;

        for (int currentIndex = start; currentIndex < end; currentIndex++) {
            if (numbers[currentIndex] < pivot) {
                leftIndex++;
                swap(numbers, leftIndex, currentIndex);
            }
        }
        swap(numbers, leftIndex + 1, end);

        return leftIndex + 1;
    }

    private void swap(int[] numbers, int leftIndex, int rightIndex) {
        int temp = numbers[leftIndex];
        numbers[leftIndex] = numbers[rightIndex];
        numbers[rightIndex] = temp;
    }

    public int[] sortWithFirstElementAsPivot(int[] numbers, int start, int end) {
        if (start < end) {
            int pivotIndex = partitionWhenPivotFirst(numbers, start, end);

            sortWithFirstElementAsPivot(numbers, start, pivotIndex - 1);
            sortWithFirstElementAsPivot(numbers, pivotIndex + 1, end);
        }
        return numbers;
    }

    private int partitionWhenPivotFirst(int[] numbers, int start, int end) {
        int pivot = numbers[start];
        int rightIndex = start + 1;

        for (int currentIndex = rightIndex; currentIndex <= end; currentIndex++) {
            if (numbers[currentIndex] < pivot) {
                swap(numbers, rightIndex, currentIndex);
                rightIndex++;
            }
        }
        int pivotIndex = rightIndex - 1;
        swap(numbers, pivotIndex, start);

        return pivotIndex;
    }
}
