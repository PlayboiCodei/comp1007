import java.io.*;
public class Equipment{
    public static void equipment(String[] args){
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("hospital_equipment.csv"))){
                while ((reader.readLine()) != null)
                    count++;
                count -= 1;
                reader.close();
        } catch (IOException e){
            System.out.println("Error"+e);
        } finally{
            System.out.println(count);
        }






        /*try {
            reader = new BufferedReader(new FileReader("hospital_equipment.csv"));
            while ((line[count] = reader.readLine()) != null) {
                System.out.println(line);
                count++;


            }
        } catch (IOException e) {
            System.out.println("error");
            
        }*/
    }
}