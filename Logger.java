import java.io.PrintWriter;

public class Logger{
    public static void log(String message){
        try(PrintWriter writer = new PrintWriter("log.txt")){
            writer.write(message + "\n");
        }catch (Exception e){
            System.out.println("Error Writing Log: " + e);
        }
    }
}