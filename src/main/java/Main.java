import static java.lang.System.out;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        out.print("$ ");
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        while (true) { 
            String input = scanner.nextLine();
            if(input.equals("exit 0")) break;
            else if (input.substring(0,4).equals("echo")) {
                out.print(input.substring(5,input.length()) + "\n");
            } else {
                out.println(input + ": command not found");
            }
            out.print("$ ");
        }
        
    }
}
