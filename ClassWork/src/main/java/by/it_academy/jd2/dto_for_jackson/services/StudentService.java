package by.it_academy.jd2.dto_for_jackson.services;

import by.it_academy.jd2.dto_for_jackson.dto.Student;
import by.it_academy.jd2.dto_for_jackson.services.api.IJsonService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IJsonService<Student> {

    private final List<Student> studentList;
    private static final StudentService instance = new StudentService();

    private StudentService() {
        studentList = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    public static StudentService getInstance() {
        return instance;
    }
}
