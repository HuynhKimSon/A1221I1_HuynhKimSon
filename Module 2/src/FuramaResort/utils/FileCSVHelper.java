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
            System.out.println("Error(read csv) Message :  " + e.getMessage());
        }

        return res;
    }

    public void write(List<T> tList, String path, boolean isAppend) {
        createIfNotExists(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend))) {
            for (T t : tList) {
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error(write csv) Message :  " + e.getMessage());
        }
    }

    public void edit(List<T> tList, String path, boolean isAppend) {
        createIfNotExists(path);
        try {
            BufferedReader BufferedReader = new BufferedReader(new FileReader(path));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend));
            String lineData, putData, data = "";

            for (T t : tList) {
                data += t.toString();
            }

            while ((lineData = BufferedReader.readLine()) != null) {
                if (lineData != null && data.charAt(0) == lineData.charAt(0)) {
                    putData = lineData.replace(lineData, data);
                    bufferedWriter.write(putData);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error(edit csv) Message :  " + e.getMessage());
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
