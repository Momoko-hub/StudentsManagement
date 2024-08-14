package raise.tech.student.management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raise.tech.student.management.controller.converter.StudentConverter;
import raise.tech.student.management.data.Student;
import raise.tech.student.management.data.StudentsCourses;
import raise.tech.student.management.domain.StudentDetail;
import raise.tech.student.management.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentsList")
  public List<StudentDetail> getStudentsList() {
    List<Student> students = service.searchStudentsList();
    List<StudentsCourses> studentsCourses= service.searchCourseList();

    return converter.convertStudentDetaols(students, studentsCourses);
  }



  @GetMapping("/studentsCoursesList")
  public List<StudentsCourses> getCourseList(){
    return service.searchCourseList();
  }

}
