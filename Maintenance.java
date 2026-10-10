import java.util.Scanner;

public class Maintenance{
    private static Equipment[] equipmentArray;
    private static Date reportDate;
    public static void maintenance(Equipment[] equipmentArray){
        Maintenance.equipmentArray = equipmentArray;
        System.out.println("============================================");
        System.out.println("           Maintenance Report");
        System.out.println("============================================");
    }
    public void getReportDate(){
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String[] DateArray = userInput.split("/");
        boolean flag = checkReportDateArray(DateArray);
    }
}

