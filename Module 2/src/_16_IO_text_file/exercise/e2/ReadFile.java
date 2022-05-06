package _16_IO_text_file.exercise.e2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        List<String> list = readFile();
        convert(list);
    }

    public static List<String> readFile() {
        List<String> stringList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/_16_IO_text_file/exercise/e2/file.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tồn tại file source");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static void convert(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            String[] strings = list.get(i).split(",");
            for (String t: strings) {
                System.out.println(t);
            }
        }
    }
}
