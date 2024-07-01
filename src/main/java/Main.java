import static java.lang.System.out;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        out.print("$ ");
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) { 
            String input = scanner.nextLine();
            if(input.equals("exit 0")) break;
            out.println(input + ": command not found");
            out.print("$ ");
        }
        
    }
}
