package popova.collection.sort;

import java.util.Objects;

public class User implements Comparable<User> {
    private Integer old;
    private String name;

    public User(String name, Integer old) {
        this.name = name;
        this.old = old;
    }

    public Integer getOld() {
        return old;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(old, user.old) &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(old, name);
    }

    @Override
    public String toString() {
        return name + " , " + old;
    }

    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }
}
