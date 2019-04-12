public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {

        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("Colorful", 100));
        studentArray.addLast(new Student("Lillian", 90));
        studentArray.addLast(new Student("unnamed", 80));
        System.out.println(studentArray);
    }
}
