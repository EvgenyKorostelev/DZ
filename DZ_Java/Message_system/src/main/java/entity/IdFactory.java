package entity;

import java.io.*;

public class IdFactory {

    public IdFactory() {
    }

    private static int ID_COUNT = 0;

    public int createId() throws IOException {

        try (BufferedReader bfr = new BufferedReader(new FileReader("src/main/resources/idCounters.txt"))) {
            String line;
            String result = "";
            while ((line = bfr.readLine()) != null) {
                result = line;
            }
            try (FileWriter fw = new FileWriter("src/main/resources/idCounters.txt", true)) {
                if (!result.isEmpty()) {
                    ID_COUNT = Integer.parseInt(result) + 1;
                    fw.write("\n" + ID_COUNT);
                } else {
                    ID_COUNT += 1;
                    fw.write("1");
                }
            }
        } catch (FileNotFoundException exception) {
            try (FileWriter fw = new FileWriter("src/main/resources/idCounters.txt")) {
                ID_COUNT += 1;
                fw.write("1");
            }
        }
        return ID_COUNT;
    }
}
