import java.io.*;

public class Equipment{ 
        // Declare Object fields
        private String equpmentID;
        private  String equipmentType; 
        private  String department;
        private  String status;
        private  String priority;
        private  Double maintenanceCost;
        private  Date lastMaintenanceDate;
        private  Date nextMaintenanceDate;
        // Construct Equipment object 
        public Equipment(String equpmentID,String equipmentType,String department,String status,String priority,Double maintenanceCost
            ,Date lastMaintenanceDate,Date nextMaintenanceDate){
                this.equpmentID = equpmentID;
                this.equipmentType = equipmentType;
                this.department = department;
                this.status = status;
                this.priority = priority;
                this.maintenanceCost = maintenanceCost;
                this.lastMaintenanceDate = lastMaintenanceDate;
                this.nextMaintenanceDate = nextMaintenanceDate;
            }
        public static Equipment[] loadEquipments(){ // Main Method
        // count lines in cvs file
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("hospital_equipment.csv"))){ 
                while ((reader.readLine()) != null){
                    count++;
                }
                count -= 1;
                reader.close();
        } catch (IOException e){
            System.out.println("Error"+e);
            return null;
        }try{
                    // add eqipment Objects to arrray
        Equipment[] eqipmentArray = new Equipment[count]; // declare equipment array
        int index = 0; 
        String line = null; // String BufferReader will push to
        BufferedReader reader = new BufferedReader(new FileReader("hospital_equipment.csv"));
        reader.readLine(); // Skips Header
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(","); // Split lines into fields
            // assign values to equpment object then push object to equipment array
            eqipmentArray[index++] = new Equipment(fields[0],fields[1],fields[2],fields[3],fields[4],
                Double.parseDouble(fields[5]),new Date(fields[6]),new Date(fields[7])); 
        }
        reader.close();
        return eqipmentArray;
        } catch (IOException e){
            System.out.println("Error"+e);
            return null;
        }
            
    }
}
        