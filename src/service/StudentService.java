package service;

import dao.StudentDAO;
import model.Student;
import java.util.List;

public class StudentService {

    private StudentDAO dao = new StudentDAO();

    public void addStudent(Student s) {
        dao.addStudent(s);
    }

    public List<Student> getAllStudents() {
        return dao.getAllStudents();
    }

    public void updateStudent(Student s) {
        dao.updateStudent(s);
    }

    public void deleteStudent(int id) {
        dao.deleteStudent(id);
    }
}