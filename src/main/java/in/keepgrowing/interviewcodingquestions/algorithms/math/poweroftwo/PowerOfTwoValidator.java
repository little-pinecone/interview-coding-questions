package in.keepgrowing.interviewcodingquestions.algorithms.math.poweroftwo;

public class PowerOfTwoValidator {

    public boolean validate(int number) {
        if (number < 2) {
            return false;
        }

        int divisionResult = number;
        while (divisionResult != 1) {
            if (divisionResult % 2 != 0) {
                return false;
            }
            divisionResult /= 2;
        }

        return true;
    }
}
