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
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Error(write csv) Message :  " + e.getMessage());
        }
    }

    public void edit(List<T> tList, String path, boolean isAppend) {
        createIfNotExists(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend))) {
            List<String> oldDataList = read(path);
            String data = "";

            // CHUYEN THANH CHUOI DU LIEU
            for (T t : tList) {
                data += t.toString();
            }
            // GAN DU LIEU MOI NEU TIM TON TAI
            for (int i = 0; i < oldDataList.size(); i++) {
                if (oldDataList.get(i).charAt(0) == data.charAt(0)) {
                    oldDataList.set(i, data);
                    break;
                }
            }
            // GHI DE DU LIEU VAO FILE
            for (int i = 0; i < oldDataList.size(); i++) {
                bufferedWriter.write(oldDataList.get(i));
                bufferedWriter.newLine();
                bufferedWriter.close();
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
