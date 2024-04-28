import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Picnic {

    public static void main(String[] args) {

        String file = "input.txt";
        countWord(readFile(file));
        longestWord(readFile(file));
        numberOfWordRepetitions(readFile(file));
    }

    public static void numberOfWordRepetitions(String str) {
        Map<String, Integer> wordRepetitions = new TreeMap<>();
        for (String word : str.split(" ")) {
            if (!wordRepetitions.containsKey(word)) {
                wordRepetitions.put(word, 1);
            } else {
                int count = wordRepetitions.get(word);
                wordRepetitions.put(word, count += 1);
            }
        }
        System.out.println("\nСписок частоты повторения каждого слова: ");
        for (Map.Entry entry : wordRepetitions.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void longestWord(String str) {

        int count = 0;
        String lengWord = "";
        for (String word : str.split(" ")) {
            if (word.length() > count) {
                lengWord = word;
                count = word.length();
            }
        }
        System.out.println("Самое длинное слово: " + lengWord + " содержит " + count + " букв.");
    }

    public static void countWord(String str) {

        int countWord = str.split(" ").length;
        System.out.println("Количество слов в файле: " + countWord);
    }

    public static String readFile(String pathToTheFile) {

        try (BufferedReader fr = new BufferedReader(new FileReader(pathToTheFile))) {
            return fr.readLine().replaceAll("\\s+", " ");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
