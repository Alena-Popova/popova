package popova.collection.convert.listtomap;

import java.util.*;
import java.util.function.Consumer;

public class ConvertList2Map {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        list.forEach((User user) -> result.put(user.getId(), user));
        return result;
    }

    public Set<User> sort(List<User> list) {
        list.sort((User u1, User u2) -> u1.compareTo(u2));
        return new TreeSet<>(list);
    }
}
