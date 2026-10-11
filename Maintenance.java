import java.util.Scanner;

public class Maintenance{
    private static Equipment[] equipmentArray;
    private static Date reportDate;
    private static int reportDateCount;
    private static int[] reportDateIndex;

    public static void maintenance(Equipment[] equipmentArrayinput){
        equipmentArray = equipmentArrayinput;
        System.out.println("============================================");
        System.out.println("           Maintenance Report");
        System.out.println("============================================");
        getReportDate();
        System.out.println(reportDate.getStringDate());




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


    public static void getItemsRequiringMaintenanceIndex(){
        int[] indexCount = new int[reportDateCount];
        int count = 0;
        for (int i = 0; i < equipmentArray.length; i++){
            String result = Date.compareDate(reportDate, equipmentArray[i].getNextMaintenanceDate());
            if (result.equals("Same") || result.equals("After")){
                indexCount[count++] = i;
            }
        }
        reportDateIndex = indexCount;
    }

    public static void getItemsRequiringMaintenanceCount(){
        int count = 0;
        for(int i=0; i < equipmentArray.length; i++){
            String result = Date.compareDate(reportDate, equipmentArray[i].getNextMaintenanceDate());
            if (result.equals("Same") || result.equals("After")){
                count++;
            }
        }
        reportDateCount = count;
    }
}

