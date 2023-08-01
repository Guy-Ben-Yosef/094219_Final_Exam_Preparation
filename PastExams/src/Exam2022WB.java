public class Exam2022WB {
    // Question 01
    static class Foo {
        public Foo() {
            f();
            g();
            h();
        }
        private void f() {
            System.out.println("Method f from Foo");
            g();
        }
        public void g() {
            System.out.println("Method g from Foo");
            h();
        }
        public static void h() {
            System.out.println("Method h from Foo");
        }
    }

    static class Bar extends Foo {
        public Bar() {
            f();
        }
        public void f() {
            System.out.println("Method f from Bar");
        }
        public void g() {
            super.g();
            System.out.println("Method g from Bar");
        }
        public static void h() {
            System.out.println("Method h from Bar");
        }
    }

    // Question 02
    static class Helper {
        private int num = 0;
        public void increase() {
            num++;
        }
        public int getNum() {
            return num;
        }
    }

    static class Node {
        private double info;
        private Node next;
        public Node(double info, Node next) {
            this.info = info;
            this.next = next;
        }
        public Node(double info) {
            this(info, null);
        }
        public double getInfo() {
            return info;
        }
        public Node getNext() {
            return next;
        }
    }

    public static double calculateSomething(Node list, Helper helper) {
        if (list == null) {
            return 0;
        }
        double value = calculateSomething(list.getNext(), helper);
        int num = helper.getNum();
        helper.increase();
        return (list.getInfo() + value * num) / (num + 1);
    }

}