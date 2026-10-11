public class Statistics{
    private static Equipment[] equipmentArray;
    public static void statistics(Equipment[] equipmentArray){
        Statistics.equipmentArray = equipmentArray;
        System.out.println("============================================");
        System.out.println("           Equipment Statistics");
        System.out.println("============================================");

    }
    public int equipmentItems(){
        return equipmentArray.length;
    }
    public int operatiaonalEquipmentItems(){
        int count = 0;
        for (int i = 0; i < equipmentArray.length;i++){
            if (equipmentArray[i].getStatus() == "Operational"){
                count++;
            }
        }
        return count;
    }
    public int UnavailableEquipmentItems(){
        int count = 0;
        for (int i = 0; i < equipmentArray.length;i++){
            if (equipmentArray[i].getStatus() == "Unavailable"){
                count++;
            }
        }
        return count;
    }


}