public class NthSeries {
    public static String seriesSum(int n) {
        double sum = 0;
        for (double i = 0; i < n; i++) {
            sum += 1 / (1 + 3 * i);
        }
        return String.format("%.2f", sum);
    }
}