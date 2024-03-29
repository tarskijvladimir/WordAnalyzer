import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordAnalyzer {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            HashMap<String, Integer> wordCount = new HashMap<>();
            String longestWord = "";
            
            while (scanner.hasNext()) {
                String word = scanner.next();
                
                // Увеличиваем счетчик для данного слова
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                
                // Проверяем, является ли текущее слово самым длинным
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            
            // Выводим количество слов в файле
            System.out.println("Количество слов в файле: " + wordCount.size());
            
            // Выводим самое длинное слово
            System.out.println("Самое длинное слово: " + longestWord);
            
            // Выводим количество повторений каждого слова
            System.out.println("Количество повторений каждого слова:");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}
