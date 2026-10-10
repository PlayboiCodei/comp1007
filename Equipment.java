import java.io.*;
public class Equipment{
    public static void equipment(String[] args){
        BufferedReader reader = null;
        String line = null;
        try {
            reader = new BufferedReader(new FileReader("hospital_equipment.csv"));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);


            }
        } catch (IOException e) {
            System.out.println("error");
            
        }
    }
}