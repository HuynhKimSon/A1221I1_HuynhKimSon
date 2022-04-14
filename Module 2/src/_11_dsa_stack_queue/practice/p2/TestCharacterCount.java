package _11_dsa_stack_queue.practice.p2;

public class TestCharacterCount {
    private static String str = "AAABBCCDDE";

    public static void main(String[] args) {
        CharacterCountTreeMap map = new CharacterCountTreeMap();
        char[] arrStr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            map.push(String.valueOf(arrStr[i]), 1);
            System.out.println(arrStr[i]);
        }
        System.out.println("Printing the elements of TreeMap: "
                + map.getMap());
    }
}
