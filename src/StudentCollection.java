import java.util.ArrayList;

public class StudentCollection {
    public ArrayList<Student> students = new ArrayList<Student>();
    
    public void startCleaning(){
        for (int i = 0; i < students.size(); i++) {
            int sumRating = 0;
            for (var rating : students.get(i).ratings.values()) {
                sumRating+=rating;
            }
            if(sumRating/students.get(i).ratings.values().size() < 3){
                students.remove(students.get(i));
                i--;
            } else {
                students.get(i).course++;
            }
        }
    }
}
