package _1_introduction_java.practice.p1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemTime {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy hh:mm:ss");
        System.out.println("Ngày giờ hiện tại : " + format.format(now));
    }
}
