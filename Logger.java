import java.io.FileWriter;

public class Logger{
    public static void log(String message){
        try(FileWriter writer = new FileWriter("log.txt",true)){
            writer.write(message + "\n");
        }catch (Exception e){
            System.out.println("Error Writing Log: " + e);
        }
    }
}