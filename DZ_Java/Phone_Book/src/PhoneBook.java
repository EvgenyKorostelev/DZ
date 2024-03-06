import java.util.*;


public class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
//  метод добавления в книгу
    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            ArrayList<Integer> list = phoneBook.get(name);
            list.add(phoneNum);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(phoneNum);
            phoneBook.put(name, list);
        }
    }
//  метод поиска в книге
    public HashMap<String, ArrayList<Integer>> find(String name) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        if (phoneBook.get(name) != null) {
            ArrayList<Integer> list = phoneBook.get(name);
            map.put(name, list);
        }
        return map;
    }
//  метод вывода/возврата книги(без сортировки)
    public static HashMap<String, ArrayList<Integer>> getPhoneBook(PhoneBook temp) {
        return phoneBook;
    }
//  метод вывода книги (сортировка по убыванию количества номеров)
    public static void outSortPBook(PhoneBook temp) {
        ArrayList<ArrayList<Integer>> val = new ArrayList<>(phoneBook.values());
        val.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        for (ArrayList<Integer> value : val) {
            for (Map.Entry<String, ArrayList<Integer>> item : phoneBook.entrySet()){
                if (item.getValue().equals(value)) {
                    String name = item.getKey();
                    System.out.println(name + ": " + value);
                    break; // исходим из того что номера уникальные и 1 номер может принадлежать только 1 пользователю
                }
            }    
        }

    }
}


