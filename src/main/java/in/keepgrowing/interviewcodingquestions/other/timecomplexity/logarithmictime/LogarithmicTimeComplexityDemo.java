package in.keepgrowing.interviewcodingquestions.other.timecomplexity.logarithmictime;

public class LogarithmicTimeComplexityDemo {

    public Integer findElementIndexWithBinarySearch(int[] sortedNumbers, int elementValue) {
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
}
