import java.io.*;
public class Equipment{
    public static void equipment(String[] args){
        String equpmentID = null;
        String equipmentType = null;
        String department = null;
        String status = null;
        String priority = null;
        Double maintenanceCost = null;
        




        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("hospital_equipment.csv"))){ //Count lines in cvs file
                while ((reader.readLine()) != null)
                    count++;
                count -= 1;
                reader.close();
        } catch (IOException e){
            System.out.println("Error"+e);
        } finally{
        
            try{
                String line = null;
                BufferedReader reader = new BufferedReader(new FileReader("hospital_equipment.csv"));
                while ((line = reader.readLine()) != null) [
                    line.split
                ]
            }

        try {
            reader = new BufferedReader(new FileReader("hospital_equipment.csv"));
            while ((line[count] = reader.readLine()) != null) {
                System.out.println(line);
        
        
        }






        try {
            reader = new BufferedReader(new FileReader("hospital_equipment.csv"));
            while ((line[count] = reader.readLine()) != null) {
                System.out.println(line);


            }
        } catch (IOException e) {
            System.out.println("error");
            
        }
    }
}