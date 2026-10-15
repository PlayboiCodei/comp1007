import java.io.BufferedReader;
import java.io.FileReader;
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
            Logger.log("Issue counting File\n Error: "+e+"System Creashes");
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
            System.out.println("Found On Line: "+ index);
            Logger.log("Issue Loading Equipment Array\n Error: "+e+"System Creashes");
            throw new Error("Issue loading Equipment Array");
        }
    }

            // Get methods
        public String returnEquipmentID(){
        return equpmentID;
        }
        public String returnEquipmentType(){
            return equipmentType;
        }
        public String returnDepartment(){
            return department;
        }
        public String returnStatus(){
            return status;
        }
        public String returnPriority(){
            return priority;
        }
        public Double returnMaintenanceCost(){
            return maintenanceCost;
        }
        public Date returnLastMaintenanceDate(){
            return lastMaintenanceDate;
        }
            public Date returnNextMaintenanceDate(){
            return nextMaintenanceDate;
        }

        public String returnLastMaintenanceDateString(){
            return lastMaintenanceDate.returnStringDate();
        }
        public String returnNextMaintenanceDateString(){
            return nextMaintenanceDate.returnStringDate();
        }

    public static void searchEquipment(){
        Equipment[] equipmentArray = Main.returnEquipmentArray();
        Scanner sc = new Scanner(System.in);
            System.out.println("============================================");
            System.out.println("               Search Equipment");
            System.out.println("============================================\n");
        while (true){
            System.out.println("Enter EquipmentID");
            System.out.print(":");
            boolean found = false;
            String equipmentSearch = sc.nextLine().strip().toUpperCase();
            if (equipmentSearch == ""){
                continue;
            }
            Logger.log("Searches For"+equipmentSearch );
            for (int i = 0; i < equipmentArray.length;i++){
                if (equipmentSearch.equals(equipmentArray[i].returnEquipmentID())){
                    System.out.println("\nEquipment Found:\n");
                    Logger.log("Equipment Found:");
                    System.out.println("---------------------------------------");
                    System.out.println("Equipment ID: " + equipmentArray[i].returnEquipmentID());
                    Logger.log("Equipment ID: " + equipmentArray[i].returnEquipmentID());
                    System.out.println("Equipment Type: " + equipmentArray[i].returnEquipmentType());
                    Logger.log("Equipment Type: " +equipmentArray[i].returnEquipmentType());
                    System.out.println("Department: " + equipmentArray[i].returnDepartment());
                    Logger.log("Department: " + equipmentArray[i].returnDepartment());
                    System.out.println("Status: " + equipmentArray[i].returnStatus());
                    Logger.log("Status: " + equipmentArray[i].returnStatus());
                    System.out.println("Priority: " + equipmentArray[i].returnPriority());
                    Logger.log("Priority: " + equipmentArray[i].returnPriority());
                    System.out.println("Maintenance Cost:" + equipmentArray[i].returnMaintenanceCost());
                    Logger.log("Maintenance Cost:" + equipmentArray[i].returnMaintenanceCost());
                    System.out.println("---------------------------------------");
                    found = true;
                }
            }
            if (!found){
                System.out.println("Item Not Found");
                Logger.log("Item Not Found");
            }if (Main.yesOrNo("Would You Like To Search Again")){
                Logger.log("Searches Again");
                continue;
            }else{
                Logger.log("Exits To Main Menu");
                return;
            }
        }
    }
    // Not Needed MEthods

    // Print all Eqipment within cell Method
    public void printAllEquipments(){
            System.out.println("EquipmentID: " + returnEquipmentID());
            System.out.println("EquipmentType: " + returnEquipmentType());
            System.out.println("Department: " + returnDepartment());
            System.out.println("Status: " + returnStatus());
            System.out.println("Priority: " + returnPriority());
            System.out.println("MaintenanceCost: " + returnMaintenanceCost());
            System.out.println("LastMaintenanceDate: " + returnLastMaintenanceDate());
            System.out.println("getNextMaintenanceDate: " + returnNextMaintenanceDate());
        }
        //Print the whole array method
    public static void printEquipmentArray(Equipment[] equipmentArray){
        for (int i=0; i < equipmentArray.length; i++){
            equipmentArray[i].printAllEquipments();
            System.out.println("---------------------------------------");
        }
    }
}


        