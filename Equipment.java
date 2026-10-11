import java.io.*;
import java.util.Scanner;

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

        } catch (Exception e){
            System.out.println("Error"+e);
            throw new Error("Issue counting File");
        }
        int index = 0; 
        try(BufferedReader reader = new BufferedReader(new FileReader("hospital_equipment.csv"))){
            reader.readLine(); // Skips Header
        // declare equipment array
        Equipment[] eqipmentArray = new Equipment[count];
        String line = null; // String BufferReader will push to
        // Assigns Fields to EqipmentObject Inside a eqipmentArray 
        while ((line = reader.readLine()) != null) 
            {
            String[] fields = line.split(","); // Split lines into fields

            // assign values to equpment object then push object to equipment array
            eqipmentArray[index++] = new Equipment(fields[0],fields[1],fields[2],fields[3],fields[4],
                Double.parseDouble(fields[5]),new Date(fields[6]),new Date(fields[7])); 
        }
        return eqipmentArray;
        
        } catch (Exception e){
            System.out.println("Error"+e);
            System.out.println("Found on line: "+ index);
            throw new Error("Issue loading Equipment Array");
        }
    }

            // Get methods
        public String getEquipmentID(){
        return equpmentID;
        }
        public String getEquipmentType(){
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
        public Date getLastMaintenanceDate(){
            return lastMaintenanceDate;
        }
            public Date getNextMaintenanceDate(){
            return nextMaintenanceDate;
        }

        public String getLastMaintenanceDateString(){
            return lastMaintenanceDate.getStringDate();
        }
        public String getNextMaintenanceDateString(){
            return nextMaintenanceDate.getStringDate();
        }

    public static void searchEquipment(Equipment[] equipmentArray){
        Scanner sc = new Scanner(System.in);
            System.out.println("============================================");
            System.out.println("               Search Equipment");
            System.out.println("============================================\n");
        while (true){
            System.out.println("Enter EquipmentID");
            System.out.print(":");
            boolean found = false;
            String equipmentSearch = sc.nextLine().strip().toUpperCase();
            for (int i = 0; i < equipmentArray.length;i++){
                if (equipmentSearch.equals(equipmentArray[i].getEquipmentID())){
                    System.out.println("\nEquipment Found:\n");
                    System.out.println("---------------------------------------");
                    System.out.println(equipmentArray[i].getEquipmentID());
                    System.out.println(equipmentArray[i].getEquipmentType());
                    System.out.println(equipmentArray[i].getDepartment());
                    System.out.println(equipmentArray[i].getStatus());
                    System.out.println(equipmentArray[i].getPriority());
                    System.out.println(equipmentArray[i].getMaintenanceCost());
                    System.out.println("---------------------------------------");
                    if(Main.yesOrNo("Would You Like To Search For Another Item Y/N")){
                        found = true;
                        continue;
                    }else{
                        return;
                    }
                }
            }
            if (found == true ||Main.yesOrNo("Item Not Found\nWould You Like to Try Again Y/N?")){
                continue;
            }else{
                return;
            }

        }
    }
    // Not Needed MEthods

    // Print all Eqipment within cell Method
    public void printAllEquipments(){
            System.out.println("EquipmentID: " + getEquipmentID());
            System.out.println("EquipmentType: " + getEquipmentType());
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


        