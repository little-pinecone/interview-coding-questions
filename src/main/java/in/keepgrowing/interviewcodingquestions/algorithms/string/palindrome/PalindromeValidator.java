package in.keepgrowing.interviewcodingquestions.algorithms.string.palindrome;

public class PalindromeValidator {

    public boolean isValid(String input) {
        if (null == input || input.isBlank()) {
            return false;
        }
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
