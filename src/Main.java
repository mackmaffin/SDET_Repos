import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        GenericClass<String> genericClass = new GenericClass<String>("строка");

        System.out.println("Пример generic-класса с generic-интерфейсом\n" + 
        genericClass.getValue());

        System.out.println("Задание 2");
        int number = in.nextInt();
        INumberCheck check = val -> val % 13 == 0;
        System.out.println(check.check(number));

        System.out.println("Задание 3");
        float a = in.nextFloat();
        float b = in.nextFloat();
        float c = in.nextFloat();
        IDiscrim count = (A, B, C) -> B*B-4*A*C;
        System.out.println(count.countD(a, b, c));
        in.close();
    }
}
