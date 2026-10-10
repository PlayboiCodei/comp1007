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

        // Main Method
        public static Equipment[] loadEquipments(){
        // count lines in cvs file
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("hospital_equipment.csv"))){ 
                reader.readLine(); // Skips header
                while ((reader.readLine()) != null){
                    count++;
                }
        } catch (IOException e){
            System.out.println("Error"+e);
            return null;
        }try(BufferedReader reader = new BufferedReader(new FileReader("hospital_equipment.csv"))){
            reader.readLine(); // Skips Header
        // declare equipment array
        Equipment[] eqipmentArray = new Equipment[count];
        int index = 0; 
        String line = null; // String BufferReader will push to
        // Assigns Fields to EqipmentObject Inside a eqipmentArray 
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(","); // Split lines into fields
            // assign values to equpment object then push object to equipment array
            eqipmentArray[index++] = new Equipment(fields[0],fields[1],fields[2],fields[3],fields[4],
                Double.parseDouble(fields[5]),new Date(fields[6]),new Date(fields[7])); 
        }
        return eqipmentArray;
        } catch (IOException e){
            System.out.println("Error"+e);
            return null;
        }
    }
    
            // Get methods
        public String getEqipmentID(){
        return equpmentID;
        }
        public String getEqipmentType(){
            return equipmentType;
        }
        public String getDepartment(){
            return department;
        }
        public String getStatus(){
            return status;
        }
        public String getPriority(){
            return priority;
        }
        public Double getMaintenanceCost(){
            return maintenanceCost;
        }
        public String getLastMaintenanceDate(){
            return lastMaintenanceDate.printStringDate();
        }
        public String getNextMaintenanceDate(){
            return nextMaintenanceDate.printStringDate();
        }

            // Print all Eqipment within cell Method
    public void printAllEquipments(){
            System.out.println("EquipmentID: " + getEqipmentID());
            System.out.println("EquipmentType: " + getEqipmentType());
            System.out.println("Department: " + getDepartment());
            System.out.println("Status: " + getStatus());
            System.out.println("Priority: " + getPriority());
            System.out.println("MaintenanceCost: " + getMaintenanceCost());
            System.out.println("LastMaintenanceDate: " + getLastMaintenanceDate());
            System.out.println("getNextMaintenanceDate: " + getNextMaintenanceDate());
        }
        //Print the whole array method
    public static void printEquipmentArray(Equipment[] equipmentArray){
        for (int i=0; i < equipmentArray.length; i++){
            equipmentArray[i].printAllEquipments();
            System.out.println("---------------------------------------");
        }
    }
    }
        
        