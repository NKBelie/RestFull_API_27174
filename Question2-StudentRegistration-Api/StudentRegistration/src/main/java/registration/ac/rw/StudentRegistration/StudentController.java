package registration.ac.rw.StudentRegistration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/students")
public class StudentController {
    List<Student> students = new ArrayList<>();
    public StudentController() {
                students.add(new Student(27174L,"Belie","NDAYISABA","belie@gmail.com","Software Engineering",3.9));
                students.add(new Student(26787L,"GISA","Lionel","lionel@gmail.com","Information Management",3.3));
                students.add(new Student(25500L,"IRUMVA","Denyse","irumva@gmail.com","Bussiness Management",3.5));
                students.add(new Student(26345L,"Ivan","GWIZA","ivan@gmail.com","Computer Science",3.8));
                students.add(new Student(27345L, "MUGISHA", "Blaise", "mugisha@gmail.com", "Software Engineering", 3.2));
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return students;
    }
    @GetMapping("/studentId")
    public Student getStudentById(@PathVariable Long studentId){
        return students.stream().filter(student -> student.getStudentId().equals(studentId)).findFirst().orElse(null);
    }
    @GetMapping
    public Student getStudentByMajor(@PathVariable String Majar){
        return students.stream().filter(student -> student.getMajor().equals(Majar)).findFirst().orElse(null);
    }
    @GetMapping("/filter")
    public Student getStudentByGPA(@PathVariable Double Gpa) {
        return students.stream().filter(student -> student.getGpa().equals(Gpa)).findFirst().orElse(null);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
    @PutMapping("/api/students/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student updateStudent){
        Student student = students.stream().filter(std -> std.getStudentId().equals(studentId)).findFirst().orElse(null);
        if(student != null){
            student.setFirstName(updateStudent.getFirstName());
            student.setLastName(updateStudent.getLastName());
            student.setEmail(updateStudent.getEmail());
            student.setMajor(updateStudent.getMajor());
            student.setGpa(updateStudent.getGpa());
        }
        return student;

}
}  
