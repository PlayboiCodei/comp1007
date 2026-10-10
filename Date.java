public class Date {
    private int day;
    private int month;
    private int year;
    private static final int[] dayCheck = {31,28,31,30,31,30,31,31,30,31,30,31};

    public Date(String dateString){
        String[] Dates = dateString.split("/");
        if (checkDateStringArray(Dates)){
            day = Integer.parseInt(Dates[0]);
            month = Integer.parseInt(Dates[1]);
            year = Integer.parseInt(Dates[2]);
        } else{
            System.out.println("Invlaid Date");
        }

    }
    public String printStringDate(){
        return String.format("%d/%d/%d",day,month,year);
    }

    public boolean checkDateStringArray(String[] dateArray){
        // Checks if list is correct size
        if (dateArray.length != 3){
            return false;
        }
        // Simple day month year var's 
        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        // Checks if fields are valid for yyyy
        if (year < 2025){
            return false;
        }
        // Checks if fields valid for mm
        else if (month > 12 || month < 1 ){
            return false;
        }
        // Checks if fields valid for dd
        else if (day  > dayCheck[month-1]|| day < 1){
            return false;
        }else{
            return true;
        }


    }

    public static String compareDate(Date date1, Date date2){ // Comparing if date 1 is happening before date 2
        if (date1.year < date2.year){
            return "Before";
        }else if (date1.year > date2.year){
            return "After";
        }else if (date1.month < date2.month){
            return "Before";
        }else if (date1.month > date2.month){
            return "After";
        }else if (date1.day < date2.day){
            return "Before";
        }else if (date1.day > date2.day){
            return "After";
        }else{
            return "Same";
        }
    }
}