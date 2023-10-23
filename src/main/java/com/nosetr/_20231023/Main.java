package com.nosetr._20231023;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	static final String fileName = "src/main/java/com/nosetr/_20231023/names.txt";

	public static void main(String[] args) {
		Main main = new Main();
		
		/*
		 * Подсчет общего числа имен в файле
		 */
		long countOfNames = main.countTotalNames(fileName);
		System.out.println(countOfNames);
		
		/*
		 * Нахождение уникальных имен в файле
		 */
		Set<String> uniqSet = main.uniqueNames(fileName);
		System.out.println(uniqSet);
		
		/*
		 * Подсчет числа имен, содержащих заданную подстроку
		 */
		System.out.println(main.countNamesContainingSubstring(fileName, "av"));
		
		/*
		 * Нахождение имен, длина которых находится в заданном диапазоне
		 */
		System.out.println(main.namesWithLengthInRange(fileName, 3, 4));
		
		/*
		 * Вывод первых N имен в алфавитном порядке
		 */
		System.out.println(main.firstNNamesAlphabetically(fileName, 3));
		
		/*
		 * Нахождение пяти самых часто встречающихся имен в файле
		 */
		System.out.println(main.topFiveCommonNames(fileName));
		
		/*
		 * Нахождение имен, которые начинаются на заданную букву и встречаются больше двух раз
		 */
		System.out.println(main.namesStartingWithAndOccurMoreThanTwice(fileName, 'a'));
		
		/*
		 * Нахождение двух имен с самой длинной и самой короткой длиной
		 */
		System.out.println(main.longestAndShortestNames(fileName));
	}
	
	/**
	 * Нахождение двух имен с самой длинной и самой короткой длиной
	 * @param fileName
	 * @return
	 */
	public Pair<String, String> longestAndShortestNames(String fileName){
		List<String> list = createList(fileName);

    String shorString = list.stream().min((x,y) -> Integer.compare(x.length(), y.length())).get();
    String longString = list.stream().max((x,y) -> Integer.compare(x.length(), y.length())).get();
		
    Pair<String, String> pair = new Pair<>(shorString, longString);
		return pair;		
	}
	
	/**
	 * Нахождение имен, которые начинаются на заданную букву и встречаются больше двух раз
	 * @param fileName
	 * @param c
	 * @return
	 */
	public Set<String> namesStartingWithAndOccurMoreThanTwice(String fileName, char c){
		List<String> list = createList(fileName).stream().filter(n -> n.toLowerCase().startsWith(String.valueOf(c))).toList();
		
    Map<String, Long> nameFrequency = list.stream()
            .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
		
		Set<String> result = nameFrequency.entrySet().stream()
				.filter(e -> e.getValue() > 2)
				.map(e -> e.getKey())
				.collect(Collectors.toSet());
		return result;
	}
	
	/**
	 * Нахождение пяти самых часто встречающихся имен в файле
	 * @param fileName
	 * @return
	 */
	public List<String> topFiveCommonNames(String fileName){
		List<String> list = createList(fileName);		

    Map<String, Long> nameFrequency = list.stream()
            .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
		
		List<String> result = nameFrequency.entrySet().stream()
				.sorted((x, y) -> Long.compare(y.getValue(), x.getValue()))
				.limit(5)
				.map(e -> e.getKey())
				.toList();
		return result;
	}
	
	/**
	 * Вывод первых N имен в алфавитном порядке
	 * @param fileName
	 * @param n
	 * @return
	 */
	public List<String> firstNNamesAlphabetically(String fileName, int n){
		List<String> list = createList(fileName);
		List<String> result = list.stream()
				.limit(n)
				.sorted(String::compareTo)
				.toList();
		return result;
	}
	
	/**
	 * Нахождение имен, длина которых находится в заданном диапазоне
	 * @param fileName
	 * @param minLength
	 * @param maxLength
	 * @return
	 */
	public List<String> namesWithLengthInRange(String fileName, int minLength, int maxLength){
		List<String> list = createList(fileName);
		List<String> result = list.stream()
				.filter(s -> (s.length() >= minLength && s.length() <= maxLength))
				.toList();
		return result;
	}
	
	/**
	 * Подсчет числа имен, содержащих заданную подстроку
	 * @param fileName
	 * @param substring
	 * @return
	 */
	public long countNamesContainingSubstring(String fileName, String substring) {
		List<String> list = createList(fileName);
		long result = list.stream().map(s -> s.toLowerCase()).filter(s -> s.contains(substring)).count();
		return result;
	}

	/**
	 * Нахождение уникальных имен в файле
	 * @param fileName
	 * @return
	 */
	public Set<String> uniqueNames(String fileName){
		List<String> list = createList(fileName);

		return list.stream().distinct().collect(Collectors.toSet());
	}

	/**
	 * Подсчет общего числа имен в файле
	 * 
	 * @param fileName
	 * @return
	 */
	public long countTotalNames(String fileName) {
		List<String> list = createList(fileName);

		return list.stream().count();
	}

	/**
	 * Helper to create list of names
	 * 
	 * @param fileName
	 * @return
	 */
	public List<String> createList(String fileName) {
		List<String> list = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}

/**
 * Нахождение двух имен с самой длинной и самой короткой длиной
 * Helper for method longestAndShortestNames
 * @param <K>
 * @param <V>
 */
class Pair<K, V> {
  private K key;
  private V value;

  public Pair(K key, V value) {
      this.key = key;
      this.value = value;
  }

  public K getKey() {
      return key;
  }

  public V getValue() {
      return value;
  }

  @Override
  public String toString() {
      return "Pair{" +
              "key=" + key +
              ", value=" + value +
              '}';
  }
}
