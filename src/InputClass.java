import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class InputClass {
    public static boolean input(String login, String password, String confirmPassword){
        try {
            if (isInvalid(login) || login.length() >= 20)
                throw new WrongLoginException("Недопустимый формат логина");
            if (isInvalid(password) || password.length() >= 20)
                throw new WrongPasswordException("Недопустимый формат пароля");
            if (!password.equals(confirmPassword))
                throw new WrongPasswordException("Пароли не совпадают");
            return true;
        } catch (WrongLoginException | WrongPasswordException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean isInvalid(String string){
        String regex = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(regex);
        return !pattern.matcher(string).matches();
    }
}
