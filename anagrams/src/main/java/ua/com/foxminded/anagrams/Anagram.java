package ua.com.foxminded.anagrams;
import java.util.*;

public class Anagram {
    public String reverse(String text) {
        String result = "Строка не должна быть пустой";
        if (text == null || text.isEmpty()) {
            return result;
        }
        String space = " ";
        List<String> listOfWords = Arrays.asList(text.split(space));
        StringBuilder sb = new StringBuilder();
        for (String eachWord : listOfWords) {
            Map<Integer, Character> nonLetters = getNonLetters(eachWord);
            String onlyLetters = removeNonLetters(eachWord);

            char[] currentWord = onlyLetters.toCharArray();
            for (int i = 0; i < currentWord.length / 2; i++) {
                if (Character.isLetter(currentWord[i])) {
                    char temp = currentWord[i];
                    currentWord[i] = currentWord[currentWord.length - 1 - i];
                    currentWord[currentWord.length - 1 - i] = temp;
                }
            }
            String reversedWord = retrieveWord(nonLetters, String.valueOf(currentWord));
            sb.append(reversedWord);
            sb.append(space);
        }
        return result = sb.toString().trim();
    }

    Map<Integer, Character> getNonLetters(String word) {
        Map<Integer, Character> nonLetters = new TreeMap();
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                nonLetters.put(i, word.charAt(i));
            }
        }
        return nonLetters;
    }

    String removeNonLetters(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }

    String retrieveWord(Map<Integer, Character> nonLetters, String text) {
        StringBuilder sb = new StringBuilder(text);

        for (Map.Entry<Integer, Character> eachEntry : nonLetters.entrySet()) {
            sb.insert(eachEntry.getKey(), String.valueOf(eachEntry.getValue()));
        }
        return sb.toString();
    }
}
