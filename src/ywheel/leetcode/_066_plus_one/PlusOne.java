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
        int carry = 1;
        for (int i=digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }
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
