package _16_IO_text_file.exercise.e1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        List<String> list = readFileSource();
        writeFileTarget(list);
    }

    public static List<String> readFileSource() {
        List<String> stringList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/_16_IO_text_file/exercice/e1/source.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                stringList.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e){
            System.out.println("Không tồn tại file source");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static void writeFileTarget(List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter("src/_16_IO_text_file/exercice/e1/target.csv", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
