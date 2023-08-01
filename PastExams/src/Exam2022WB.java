public class Exam2022WB {
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

}