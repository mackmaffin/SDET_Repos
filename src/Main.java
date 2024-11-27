import java.util.List;

public class Main {
    public static void main(String[] args){
        StudentCollection collection = new StudentCollection();

        Student student = new Student("Artyom", "PIbd-33", 3);
        student.ratings.put("Math", 5);
        student.ratings.put("English", 3);
        student.ratings.put("Russian", 4);
        collection.students.add(student);

        Student student1 = new Student("Rostislave", "PIbd-33", 2);
        student1.ratings.put("Math", 5);
        student1.ratings.put("English", 5);
        student1.ratings.put("Russian", 5);
        collection.students.add(student1);

        var student2 = new Student("Niyaz", "PIbd-33", 2);
        student2.ratings.put("Math", 3);
        student2.ratings.put("English", 2);
        student2.ratings.put("Russian", 3);
        collection.students.add(student2);

        var student3 = new Student("Egor", "PIbd-33", 4);
        student3.ratings.put("Math", 2);
        student3.ratings.put("English", 2);
        student3.ratings.put("Russian", 2);
        collection.students.add(student3);

        printStudents(collection.students, 2);
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||");
        
        collection.startCleaning();
        printStudents(collection.students, 3);
    }

    private static void printStudents(List<Student> students, int cource){
        for (var student : students) {
            if (student.course == cource)
                System.out.println(student.name);
        }
    }    
}