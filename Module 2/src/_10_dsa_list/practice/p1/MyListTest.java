package _10_dsa_list.practice.p1;

public class MyListTest<E> {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        System.out.println("----------Thêm phần tử-------------");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        print(list.getData());
        System.out.println("size : " + list.size());
        System.out.println("----------Chèn phần tử-------------");
        list.add(12, "HAHA");
        print(list.getData());
        System.out.println("size : " + list.size());
        System.out.println("----------Lấy phần tử-------------");
        System.out.println("get item : " + list.get(11));
        System.out.println("size : " + list.size());
        System.out.println("----------Trả về vị trí của item-------------");
        System.out.println("Index : " + list.indexOf("HAHA"));
        print(list.getData());
        System.out.println("size : " + list.size());
        System.out.println("----------Tồn tại của item-------------");
        System.out.println("contains : " + list.contains("HAHA"));
        System.out.println("size : " + list.size());
        System.out.println("----------Xoá phần tử-------------");
        System.out.println("Remove : " + list.remove(5));
        print(list.getData());
        System.out.println("size : " + list.size());
        System.out.println("----------Xoá tất cả phần tử-------------");
        list.clear();
        print(list.getData());
        System.out.println("size : " + list.size());

    }

    static void print(Object[] list) {
        for (Object x : list) {
            if (!(x == null)) {
                System.out.println("item : " + x);
            }
        }
        System.out.println("\n");
    }

}
