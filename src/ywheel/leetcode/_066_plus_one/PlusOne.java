package ywheel.leetcode._066_plus_one;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author ywheel
 * 
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        boolean flag = digits[digits.length - 1] == 9 ? true : false;
        digits[digits.length - 1] = (digits[digits.length - 1] + 1) % 10;
        if (!flag) {
            return digits;
        }
        for (int i=digits.length - 2; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] < 10) {
                flag = false;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        // flag must be true
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        return newDigits;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int[] result = solution.plusOne(new int[] { 9, 9, 9 });
        if (result != null) {
            for (int i : result) {
                System.out.print(i);
            }
        }
    }
}
