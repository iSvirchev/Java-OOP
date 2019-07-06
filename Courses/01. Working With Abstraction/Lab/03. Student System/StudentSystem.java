import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem(){
        this.repo = new HashMap<>();
    }

    public void addStudent (Student student){
        String name = student.getName();
        repo.putIfAbsent(name,student);
    }

    public void showStudent(String name) {
        if (repo.containsKey(name)){
            Student student = repo.get(name);
            String view = String.format("%s is %d years old.",student.getName(),student.getAge());

            if (student.getGrade() >= 5.00)view += " Excellent student.";
            else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)view += " Average student.";
            else view += " Very nice person.";

            System.out.println(view);
        }
    }
}
