public class Date {
    private int day;
    private int month;
    private int year;

    public Date(String dateString){
        String[] Dates = dateString.split("/");
        
        day = Integer.parseInt(Dates[0]);
        month = Integer.parseInt(Dates[1]);
        year = Integer.parseInt(Dates[2]);

    }
    public String printStringDate(){
        return String.format("%d/%d/%d",day,month,year);
    }

    public static String compareDate(Date date1, Date date2){
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