package code.patterns.architectural.mvc;

public class MvcDemo {
    public static void main(String[] args) {
        Student model = fetchStudentFromDatabase();
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();
    }

    public static Student fetchStudentFromDatabase() {
        Student student = new Student();
        student.setName("Matthew");
        student.setRollNo("13PR");
        return student;
    }
}
