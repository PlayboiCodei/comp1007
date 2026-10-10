import java.io.*;
public class Equipment{
    public static void equipment(String[] args){
        BufferedReader reader = null;
        String line = null;
        int count = 0;
        try{
        reader = new BufferedReader(new FileReader("hospital_equipment.csv"));
        while ((line = reader.readLine()) != null)
            count++;
        reader.close();
        } catch (IOException e){
            System.out.println("Error"+e);
        } finally{
            System.out.println(count);
        }
    }
}





        /*try {
            reader = new BufferedReader(new FileReader("hospital_equipment.csv"));
            while ((line[count] = reader.readLine()) != null) {
                System.out.println(line);
                count++;


            }
        } catch (IOException e) {
            System.out.println("error");
            
        }
    }
}*/