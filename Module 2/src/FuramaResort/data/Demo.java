package FuramaResort.data;

public class Demo {
    static int count = 0;
    /*se lay bo nho (memory) khi bien instance duoc tao*/

    /*Ket qua thuc hien chuong trinh hien ra 3 so 1 o 3 dong*/
    Demo() {
        count++;
        System.out.println(count);
    }

    public static void main(String args[]) {
        Demo c1 = new Demo();
        Demo c2 = new Demo();
        Demo c3 = new Demo();
    }
}
