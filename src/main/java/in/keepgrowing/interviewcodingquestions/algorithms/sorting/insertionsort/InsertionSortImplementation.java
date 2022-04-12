package in.keepgrowing.interviewcodingquestions.algorithms.sorting.insertionsort;

public class InsertionSortImplementation {

    public int[] sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {

            int current = numbers[i];
            int previousIndex = i - 1;

            while (previousIndex >= 0 && numbers[previousIndex] > current) {
                numbers[previousIndex + 1] = numbers[previousIndex];
                previousIndex = previousIndex - 1;
            }
            numbers[previousIndex + 1] = current;
        }

        return numbers;
    }
}
