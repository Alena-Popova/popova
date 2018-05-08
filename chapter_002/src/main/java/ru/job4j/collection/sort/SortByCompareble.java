package popova.collection.sort;

import java.util.*;

/**
 * 2. Сортировка User с использованием Comparator [#10036]
 */
public class SortByCompareble {

    /**
     * Сортировка по длине имени.
     * @param userList  входной массив
     * @return List<User> отстортированный по длине имени
     */
    public Set<User> sortNameLength (List<User> userList) {
        return new TreeSet<User>(userList);
    }

    /**
     * сортировка по имени в лексикографическом порядке, потом по возрасту.
     * @param userList входной массив
     * @return отсортированный List<User> по обоим полям
     */
    public List<User> sortByAllFields (List<User> userList) {
        userList.sort(Comparator.comparing((User o) -> o.getName().split(" ")[0]).thenComparing(o -> o.getOld()));
        return userList;
    }

}
