package Service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnDate {

    public static String returnDate(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY年MM月dd日HH:mm:ss");
        String dateStr=sdf.format(date);
        return dateStr;
    }

    public static void main(String[] args) {
        System.out.println(returnDate());
    }

}
