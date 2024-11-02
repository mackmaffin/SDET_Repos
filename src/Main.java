import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.println("Повторите пароль: ");
        String confirmPassword = scanner.nextLine();
        boolean result = InputClass.input(login, password, confirmPassword);
        if (result)
            System.out.println("Значения приняты");
        else
            System.out.println("Значения не приняты");
    }
}
