package entity;

import java.io.*;

public class IdFactory {

    public IdFactory() {
    }

    public int createId() throws IOException {
        try (BufferedReader bfr = new BufferedReader(new FileReader("idCounters.txt"))) {
            String line;
            String result = "";
            while ((line = bfr.readLine()) != null) {
                result = line;
            }
            try (FileWriter fw = new FileWriter("idCounters.txt")) {
                if (!result.isEmpty()) {
                    fw.write(String.valueOf(Integer.parseInt(result) + 1));
                    return Integer.parseInt(result);
                } else {
                    fw.write("1");
                    return 1;
                }
            }
        } catch (FileNotFoundException exception) {
            File file = new File("idCounters.txt");
            try (FileWriter fw = new FileWriter("idCounters.txt")) {
                fw.write("1");
            }
            return 1;
        }
    }

}
