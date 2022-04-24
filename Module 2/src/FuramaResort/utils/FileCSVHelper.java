package FuramaResort.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCSVHelper<T> {

    public List<String> read(String path) {
        List<String> res = new ArrayList<>();
        createIfNotExists(path);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error(read txt) Message :  " + e.getMessage());
        }

        return res;
    }

    public void write(List<T> tList, String path, boolean isAppend) {
        createIfNotExists(path);
        System.out.println(tList);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend))) {
            for (T t : tList) {
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error(write txt) Message :  " + e.getMessage());
        }
    }

    private void createIfNotExists(String path) {
        try {
            File file = new File(path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error(createIfNotExists) Message :  " + e.getMessage());
        }
    }
}
