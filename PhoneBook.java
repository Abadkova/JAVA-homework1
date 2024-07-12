import java.util.*;

public class PhoneBook {

    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phone);
    }

    public void printContacts() {
        List<Map.Entry<String, Set<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        for (Map.Entry<String, Set<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Alice", "12345");
        phoneBook.addContact("Bob", "67890");
        phoneBook.addContact("Alice", "54321");
        phoneBook.addContact("Charlie", "11111");
        phoneBook.addContact("Bob", "22222");
        phoneBook.printContacts();
    }
}
