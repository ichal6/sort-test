import java.util.Scanner;

public class InputManager {

    public String getStringInput(String message) {
        System.out.println(message);
        Scanner scannerFromUser = new Scanner(System.in);
        String input = scannerFromUser.nextLine();
        
        return input;
    }

    public int getIntInput(String message) {
        System.out.println(message);
        int input = 0;
        Scanner scannerFromUser = new Scanner(System.in);

        while(!scannerFromUser.hasNextInt()){
            System.out.println("Wrong input! Please insert the integer number");
            scannerFromUser.next();
        }
        input = scannerFromUser.nextInt();
        
        return input;
    }
}