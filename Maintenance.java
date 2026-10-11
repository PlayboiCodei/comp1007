import java.util.Scanner;

public class Maintenance{
    private static Equipment[] equipmentArray;
    private static Date reportDate;
    private static int requireMaintenanceCount;
    private static int[] requireMaintenanceArray;
    private static int highPriorityMaintenanceCount;

    public static void maintenance(Equipment[] equipmentArrayinput){
        equipmentArray = equipmentArrayinput;
        System.out.println("============================================");
        System.out.println("           Maintenance Report");
        System.out.println("============================================");
        getReportDate();
        getItemsRequiringMaintenanceCount();
        getItemsRequiringMaintenanceIndex();
        getHighPriorityMaintenanceCount();
        printMaintenanceReport();
    }

    public static void printMaintenanceReport(){
        int index = 0;
        for (int i = 0; i < requireMaintenanceCount; i++){
            index = requireMaintenanceArray[i];
            System.out.println(equipmentArray[index].getEquipmentID());
            System.out.println(equipmentArray[index].getEquipmentType());
            System.out.println(equipmentArray[index].getDepartment());
            System.out.println(equipmentArray[index].getPriority());
            System.out.println(equipmentArray[index].getNextMaintenanceDateString());
            System.out.println("--------------------------------------------");
        }
    }




    public static void getHighPriorityMaintenanceCount(){
        int count = 0;
        for (int i = 0; i < requireMaintenanceCount; i++){
            String result = equipmentArray[requireMaintenanceArray[i]].getPriority();
            if (result.equals("High")){
                count++;
            }
        }
        highPriorityMaintenanceCount = count;
    }


    public static void getItemsRequiringMaintenanceIndex(){
        int[] array = new int[requireMaintenanceCount];
        int count = 0;
        for (int i = 0; i < equipmentArray.length; i++){
            String result = Date.compareDate(reportDate, equipmentArray[i].getNextMaintenanceDate());
            if (result.equals("Same") || result.equals("After")){
                array[count++] = i;
            }
        }
        requireMaintenanceArray = array;
    }

    public static void getItemsRequiringMaintenanceCount(){
        int count = 0;
        for(int i=0; i < equipmentArray.length; i++){
            String result = Date.compareDate(reportDate, equipmentArray[i].getNextMaintenanceDate());
            if (result.equals("Same") || result.equals("After")){
                count++;
            }
        }
        requireMaintenanceCount = count;
    }

        public static void getReportDate(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Enter Report Date \ndd/mm/yyyy\n: ");
            String userInput = sc.nextLine();
            try{
                reportDate = new Date(userInput);
                return;
            }
            catch (Exception e){
                System.out.println("Error "+e);
                continue;
            }
        }
    }
}



