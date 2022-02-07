package kr.co.haedoang.demo.student;

/**
 * packageName : kr.co.haedoang.demo.student
 * fileName : Student
 * author : haedoang
 * date : 2022-02-04
 * description :
 */
public class Student {
    private final Integer studentId;
    private final String studentName;

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
