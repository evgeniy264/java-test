import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, String> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void add(String a, String b) {
        map.put(a, b);
    }

    public void get(String c) {
        if (map.containsValue(c)) {
            System.out.println("Номера телефонов для " + c + ":");
            for (Map.Entry<String, String> o : map.entrySet()) {
                if (o.getValue().equals(c)) {
                    System.out.println(o.getKey());
                }
            }
        } else {
            System.out.println("Данная фамилия отсутствует в справочнике");
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("89056881863", "Иванов");
        phoneBook.add("89156873432", "Иванов");
        phoneBook.add("89785443223", "Петров");
        phoneBook.add("89904553553", "Серебряков");
        phoneBook.add("89984563553", "Демин");
        phoneBook.get("Иванов");
    }
}
