import java.util.*;

public class UniqueAutomobiles {
    public static void main(String[] args) {
        String[] array = {"форд", "ситроен", "рено", "газ", "уаз", "форд", "рено", "газ", "хавейл", "скания", "маз", "маз", "камаз", "мицубиси", "мицубиси"};
        List<String> auto = Arrays.asList(array);
        System.out.println("Исходный список:");
        System.out.println(auto);
        System.out.println("\nСписок слов без дубликатов: ");
        Set<String> unique = new LinkedHashSet<>(auto);
        System.out.println(unique);
        System.out.println("\nКоличество повторов слов:");
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : auto) {
            Integer count = wordsCount.get(word);
            if (count == null) {
                count = 0;
            }
            wordsCount.put(word, count + 1);
        }
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Слово '" + entry.getKey() + "' встречается " + entry.getValue() + " раза");
            } else {
                System.out.println("Слово '" + entry.getKey() + "' встречается " + entry.getValue() + " раз");
            }
        }
    }
}

