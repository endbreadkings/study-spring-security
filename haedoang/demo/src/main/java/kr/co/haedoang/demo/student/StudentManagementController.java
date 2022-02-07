package kr.co.haedoang.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * packageName : kr.co.haedoang.demo.student
 * fileName : StudentManagementController
 * author : haedoang
 * date : 2022-02-07
 * description :
 */
@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "haedoang"),
            new Student(2, "marry"),
            new Student(3, "jack")
    );

    @GetMapping
    public List<Student> getLAllStudents() {
        System.out.println("getAllStudents");
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("insertStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", studentId, student));
    }
}
