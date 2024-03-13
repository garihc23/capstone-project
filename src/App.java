import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("PASSWORD VALIDATOR");

        boolean flag = false, exit = false;

        Test test = new Test();
        Scanner sc = new Scanner(System.in);
        UserCredentials userCredentials = new UserCredentials();
        for (int k = 1;; k++) {
            if (k > 1)
                System.out.println("Maximumn Tries Reached. Retry");
            Input in = new Input();
            in.get_user(userCredentials);
            for (int i = 1; i <= 6; i++) {
                flag = false;
                in.get_pass(userCredentials);
                try {
                    test.pass_min_length(userCredentials.getPassword());
                    test.pass_max_length(userCredentials.getPassword());
                    test.passContainsUpperCase(userCredentials.getPassword());
                    test.passContainsLowerCase(userCredentials.getPassword());
                    test.passContainsDigits(userCredentials.getPassword());
                    test.passContainsThreeSpecialChars(userCredentials.getPassword());
                    test.passStartsWithSchar2Digit(userCredentials.getPassword());
                    test.passContains3Upper3LowerChar(userCredentials.getPassword());
                    test.passSameCharSequenceCheck(userCredentials.getPassword());
                    test.passContainsUsername(userCredentials.getUsername(),
                            userCredentials.getPassword());
                    test.passScharSequenceCheck(userCredentials.getPassword());
                    test.passCommonPasswords(userCredentials.getPassword());
                    flag = true;
                } catch (InvalidPassword e) {
                    System.out.println("Invalid Password! " + e);
                }
                if (!flag && i <= 5 && i % 3 == 0) {
                    System.out.println("Do you want to retry? Yes or No");
                    String reply = sc.nextLine();
                    if (reply.charAt(0) == 'N' || reply.charAt(0) == 'n') {
                        exit = true;
                        break;
                    }
                } else if (flag) {
                    exit = true;
                    break;
                }
            }
            if (exit)
                break;
        }
        // System.out.println(user + " " + pass);
    }
}
