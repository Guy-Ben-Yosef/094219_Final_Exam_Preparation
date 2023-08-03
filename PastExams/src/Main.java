import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        double x = Exam2022WB.calculateSomething(
                new Exam2022WB.Node(
                        1, new Exam2022WB.Node(
                                2, new Exam2022WB.Node(
                                        3, new Exam2022WB.Node(4)))),
                new Exam2022WB.Helper());
        System.out.println(x);
    }
}