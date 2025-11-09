package javaProgramming.demo28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonSortDemo {
    public static void main(String[] args) {
        List<Person> personList = createPersonList();
        System.out.println("\n=== 原始Person列表 ===");
        displayPersonList(personList);
        System.out.println("\n=== 按年龄升序排序 ===");
        sortByAgeAscending(personList);
        displayPersonList(personList);
    }

    private static List<Person> createPersonList() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("张三", 25));
        persons.add(new Person("李四", 30));
        persons.add(new Person("王五", 22));
        persons.add(new Person("赵六", 28));
        persons.add(new Person("钱七", 35));
        persons.add(new Person("孙八", 19));
        return persons;
    }

    private static void sortByAgeAscending(List<Person> personList) {
        Collections.sort(personList, new AgeComparator());
    }

    private static void displayPersonList(List<Person> personList) {
        for (int i = 0; i < personList.size(); i++) {
            System.out.println((i + 1) + ". " + personList.get(i));
        }
    }
}