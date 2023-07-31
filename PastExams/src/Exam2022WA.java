public class Exam2022WA {
    // Question 01
    public static void adjacentHanoi(int n, String A, String B, String C) {
        if (n == 0) {
            return;
        }
        adjacentHanoi(n - 1, A, B, C);
        System.out.println("Move disk from " + A + " To " + B);
        adjacentHanoi(n - 1, C, B, A);
        System.out.println("Move disk from " + B + " To " + C);
        adjacentHanoi(n - 1, A, B, C);
    }
}
