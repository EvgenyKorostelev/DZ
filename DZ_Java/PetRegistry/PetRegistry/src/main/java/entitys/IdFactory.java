package entitys;

import java.io.*;

public class IdFactory {

    public IdFactory() {
    }

    private static int ID_COUNT = 0;

    public int createId() throws IOException {//Создайте класс Счетчик, у которого есть метод add()

        try (BufferedReader bfr = new BufferedReader(new FileReader("idCounters.txt"))) {
            String line;
            String result = "";
            while ((line = bfr.readLine()) != null) {
                result = line;
            }
            try (FileWriter fw = new FileWriter("idCounters.txt", true)) {
                if (!result.isEmpty()) {
                    ID_COUNT = Integer.parseInt(result) + 1;
                    fw.write("\n" + ID_COUNT);
                } else {
                    ID_COUNT += 1;
                    fw.write("1");
                }
            }
        } catch (FileNotFoundException exception) {
            File file = new File("idCounters.txt");
            try (FileWriter fw = new FileWriter("idCounters.txt")) {
                ID_COUNT += 1;
                fw.write("1");
            }
        }
        return ID_COUNT;
    }
}
