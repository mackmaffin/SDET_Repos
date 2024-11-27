import java.util.HashMap;

public class Student {
    public String name;
    public String group;
    public int course;
    public HashMap<String, Integer> ratings = new HashMap<>();
    
    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }   
}
