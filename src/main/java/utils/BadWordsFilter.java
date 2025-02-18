package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BadWordsFilter {
    private static Set<String> badWords;
    private static final String BAD_WORDS_FILE = "/bad_words.txt";

    static {
        loadBadWords();
    }

    private static void loadBadWords() {
        badWords = new HashSet<>();
        try (InputStream is = BadWordsFilter.class.getResourceAsStream(BAD_WORDS_FILE);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (!line.isEmpty() && !line.startsWith("#")) { // Ignore les lignes vides et les commentaires
                    badWords.add(line);
                }
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Erreur lors du chargement des mots inappropriés : " + e.getMessage());
            // Charger une liste par défaut en cas d'erreur
            badWords.add("badword");
        }
    }

    public static void reloadBadWords() {
        loadBadWords();
    }

    public static boolean containsBadWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (badWords.contains(cleanWord)) {
                return true;
            }
        }
        return false;
    }

    public static String findBadWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }

        StringBuilder foundBadWords = new StringBuilder();
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (badWords.contains(cleanWord)) {
                if (foundBadWords.length() > 0) {
                    foundBadWords.append(", ");
                }
                foundBadWords.append(word);
            }
        }
        return foundBadWords.toString();
    }

    public static String moderateText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return text;
        }

        for (String badWord : badWords) {
            // Créer un pattern qui matche le mot même avec des caractères entre les lettres
            StringBuilder patternBuilder = new StringBuilder();
            for (char c : badWord.toCharArray()) {
                if (patternBuilder.length() > 0) {
                    patternBuilder.append("[\\s.,_-]*");
                }
                patternBuilder.append(c);
            }
            String pattern = "(?i)" + patternBuilder.toString();

            // Remplacer chaque occurrence par des astérisques
            text = text.replaceAll(pattern, "*".repeat(badWord.length()));
        }

        return text;
    }
}
