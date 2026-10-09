import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class StopWordFilteredWordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        List<String> stopWords = Arrays.asList("the", "was", "and", "a", "is", "of", "in");
        
        // Normalize and remove punctuation
        String normalized = feedback.toLowerCase().replace(".", "").replace(",", "");
        
        // Split text
        String[] words = normalized.split("\\s+");
        
        Map<String, Integer> wordCounts = new HashMap<>();
        
        for (String word : words) {
            if (!stopWords.contains(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by frequency descending
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCounts.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
