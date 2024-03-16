package brockmowry_sec001_ex01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
	
	// i remade this

	private final String sentence;
	private final Map<String, Integer> wordCounts;
	private final Map<String, Integer> duplicateWords;

	public WordCount(String sentence) {
		this.sentence = sentence;
		wordCounts = loadWordCounts();
		duplicateWords = loadDuplicateWords();
	}

	private Map<String, Integer> loadWordCounts() {
		var map = new HashMap<String, Integer>();
		var split = sentence.toLowerCase().split(" ");
		Arrays.stream(split).forEach(splitElement -> {
			if (map.containsKey(splitElement)) {
				var current = map.get(splitElement);
				map.replace(splitElement, current + 1);
			} else {
				map.put(splitElement, 1);
			}
		});

		return map;
	}

	private Map<String, Integer> loadDuplicateWords() {
		var map = new HashMap<String, Integer>();
		wordCounts.forEach((key, value) -> {
			if (value > 1)
				map.put(key, value);
		});

		return map;
	}

	@Override
	public String toString() {
		var builder = new StringBuilder(String.format("%s\n\n", sentence));

		builder.append("Word Counts:\n");
		wordCounts.forEach((key, value) -> builder.append(String.format("%s - %d\n", key, value)));

		builder.append("\nDuplicate words:\n");
		duplicateWords.forEach((key, value) -> builder.append(String.format("%s - %d\n", key, value)));

		return builder.toString();
	}
	
	public static void main(String[] args) {
		var wordCount = new WordCount("The quick brown fox jumps over the lazy dog.");
		System.out.println(wordCount.toString());
	}

}