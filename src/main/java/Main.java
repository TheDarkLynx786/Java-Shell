import static java.lang.System.getenv;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        out.print("$ ");
        
        String[] cmds = {"exit","echo", "type"};

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        while (true) { 
            String input = scanner.nextLine();
            //Checker Code
            if(input.equals(cmds[0] + " 0")) break;   //Exit
            else if (input.split(" ")[0].equals(cmds[1])) {   //Echo Builtin
                out.print(input.substring(5, input.length()) + "\n");
            } else if (input.split(" ")[0].equals(cmds[2])){   //Type Builtin
                
                String toCmpr = input.substring(5, input.length());
                boolean valid = false;
                for (String cmd : cmds) {   //Iterate through cmds list; check for builtin
                    if(cmd.equals(toCmpr)) valid = true;
                }
                
                //Check for valid path
                String foundPath = Pathfinder(toCmpr);
                
                if(valid) out.println(toCmpr + " is a shell builtin");
                else if (!"".equals(foundPath)) {
                    out.println(toCmpr + " is " + foundPath);
                }
                else out.println(toCmpr + ": not found");


            } else {
                String[] inpln = input.split(" ");
                String cmd = inpln[0];

                String path = Pathfinder(cmd);

                if("".equals(path)) out.println(cmd + ": command not found");
                else {
                    String extdPath = path + " " + inpln[1];
                    Process exec = Runtime.getRuntime().exec(extdPath.split(" "));
                    exec.getInputStream().transferTo(out);
                }
            }

            out.print("$ ");
        }
        
    }
    static private String Pathfinder(String file) {
        for (String path : getenv("PATH").split(":")) {
            Path filePath = Path.of(path, file);
            if (Files.isRegularFile(filePath)) return filePath.toString();
        }

        return ""; 
    }
}
