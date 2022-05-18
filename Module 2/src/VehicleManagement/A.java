package VehicleManagement;

public class A {
    public static void main(String[] args) {
       test();
    }

    private static int test(){
        try{
            return 1;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return 1;
        }
        finally {
            System.out.println("hello");
        }
    }
}
