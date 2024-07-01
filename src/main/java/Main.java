import static java.lang.System.out;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        out.print("$ ");
        
        String[] cmds = {"exit","echo", "type"};

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        while (true) { 
            String input = scanner.nextLine();
            if(input.equals(cmds[0] + " 0")) break;
            else if (input.substring(0,4).equals(cmds[1])) {
                out.print(input.substring(5,input.length()) + "\n");
            } else if (input.substring(0,4).equals(cmds[2])){
                String toCmpr = input.substring(5,input.length());
                boolean valid = false;
                for (String cmd : cmds) {
                    if(cmd.equals(toCmpr)) valid = true;
                }
                if(valid) out.println(toCmpr + " is a shell builtin");
                else out.println(toCmpr + ": command not found");
            } else {
                out.println(input + ": command not found");
            }
            out.print("$ ");
        }
        
    }
}
