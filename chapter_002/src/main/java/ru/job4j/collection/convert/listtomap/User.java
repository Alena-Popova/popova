package popova.collection.convert.listtomap;

import java.util.Objects;

public class User implements Comparable<User> {
    private Integer id;
    private String sity;
    private String name;

    public User(Integer id, String sity, String name) {
        this.id = id;
        this.sity = sity;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getSity() {
        return sity;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(sity, user.sity) &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sity, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sity= '" + sity + '\'' +
                ", name= '" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        int result = this.getId().equals(o.getId()) ? this.getId().compareTo(o.getId()) : this.getName().compareTo(o.getName());
        return result;
    }
}
