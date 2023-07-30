public class TwoArePositive {

    public static boolean twoArePositive(int a, int b, int c) {
        int[] arr = {a, b, c};
        int count = 0;
        for (int num : arr) {
            if (num > 0) {
                count++;
            }
        }
        return count == 2;
    }
}