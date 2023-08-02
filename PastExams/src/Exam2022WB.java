import java.util.*;

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

    // Question 03
    static class AcademicPerson {
        protected String name;
        protected int age;
        protected String mail;

        public AcademicPerson(String name, int age, String mail) {
            this.name = name;
            this.age = age;
            this.mail = mail;
        }
    }

    static class Professor extends AcademicPerson {
        private int salary;
        private int seniority;

        public Professor(String name, int age, String mail, int salary, int seniority) {
            super(name, age, mail);
            this.salary = salary;
            this.seniority = seniority;
        }

        public int getSalary() {
            return salary;
        }

        public int getSeniority() {
            return seniority;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public void setSeniority(int seniority) {
            this.seniority = seniority;
        }
    }

    static class Student extends AcademicPerson {
        private double gpa;
        private double grade;

        public Student(String name, int age, String mail, double gpa, double grade) {
            super(name, age, mail);
            this.gpa = gpa;
            this.grade = grade;
        }

        public double getGpa() {
            return gpa;
        }

        public double getGrade() {
            return grade;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }
    }

    static class Course implements Cloneable, Iterable<Student> {
        private String name;
        private String id;
        private Professor professor;
        private List<Student> students = new ArrayList<>();
        private boolean isFactored;
        private double iterationThresholdGrade;

        public Course(String name, String id, Professor professor, boolean isFactored) {
            this.name = name;
            this.id = id;
            this.professor = professor;
            this.isFactored = isFactored;
            this.iterationThresholdGrade = 0;
        }

        public Course(String name, String id, Professor professor, List<Student> students, boolean isFactored) {
            new Course(name, id, professor, isFactored);
            this.students = students;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public Professor getProfessor() {
            return professor;
        }

        public List<Student> getStudents() {
            return students;
        }

        public boolean isFactored() {
            return isFactored;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setProfessor(Professor professor) {
            this.professor = professor;
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void removeStudent(Student student) {
            students.remove(student);
        }

        public void setFactored(boolean factored) {
            isFactored = factored;
        }

        @Override
        public Course clone() {
            try {
                Course cloned = (Course) super.clone();
                cloned.professor = professor;
                cloned.students = new ArrayList<>(students);
                return cloned;
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        public double getThresholdGrade() {
            return iterationThresholdGrade;
        }

        @Override
        public Iterator<Student> iterator() {
            return new CourseIterator(this, iterationThresholdGrade);
        }

        public void setThresholdGrade(double thresholdGrade) {
            this.iterationThresholdGrade = thresholdGrade;
        }


    }

    static class CourseIterator implements Iterator<Student> {
        private Course course;
        private List<Student> students;
        private int index;
        private int lastValidIndex;
        private double thresholdGrade;

        public CourseIterator(Course course, double thresholdGrade) {
            this.course = course;
            this.students = course.getStudents();
            this.index = -1;
            this.thresholdGrade = thresholdGrade;
            this.lastValidIndex = findLastValidIndex();
        }

        public int findLastValidIndex() {
            int lastValidIndex = students.size() - 1;
            while (lastValidIndex >= 0) {
                if (students.get(lastValidIndex).getGrade() >= thresholdGrade) {
                    break;
                }
                lastValidIndex--;
            }
            return lastValidIndex;
        }

        @Override
        public boolean hasNext() {
            if (index <= lastValidIndex) {
                return true;
            }
            return false;
        }

        @Override
        public Student next() {
            index++;
            while (students.get(index).getGrade() < thresholdGrade) {
                index++;
            }
            return students.get(index);
        }
    }

    // Question 04

    }