package Maps;
import java.util.Map;
import java.util.HashMap;

public class HashMapThree {

    public static void main(String[] args) {
        Map<Student, School> careerFair = new HashMap<>();
        // schools
        School jameBowieHS = new School("James Bowie", "Arlington");
        // School langstonUniversityOKC = new School("Langston University OKC", "Oklahoma City");
        School viewParkHS = new School("View Park", "Denton");
        // students
        Student student01 = new Student("Kierstin", 12);
        Student student02 = new Student("Deron", 12);

        Student student03 = new Student("Glenn", 12);
        Student student04 = new Student("Jasmine", 12);

        careerFair.put(student01, viewParkHS);
        careerFair.put(student02, jameBowieHS);
        careerFair.put(student03, viewParkHS);
        careerFair.put(student04, jameBowieHS);

        careerFair.entrySet().stream().filter(entry -> entry.getKey().getGrade() > 10).forEach(entry -> {
            System.out.println(entry.getKey().getStudent() +" "+ entry.getValue().getSchoolName());
        });

    }
    
}

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getStudent(){
        return this.name;
    }

    public int getGrade(){
        return this.grade;
    }

}

class School {
    String name;
    String city;

    School(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getSchoolName() {
        return this.name;
    }
}
