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
}