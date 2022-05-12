package Bank.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCSVHelper<T> {

    public List<String> read(String path) {
        List<String> res = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res.add(line);
            }
        } catch (IOException e) {
            System.out.println("--->ERROR(read csv) Message :  " + e.getMessage());
        }
        return res;
    }

    public void write(List<T> tList, String path, boolean isAppend) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend))) {
            for (T t : tList) {
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("--->ERROR(write csv) Message :  " + e.getMessage());
        }
    }
}
