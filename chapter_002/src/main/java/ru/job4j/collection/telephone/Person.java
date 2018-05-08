package popova.collection.telephone;

import java.util.Objects;

public class Person {
    private String number;
    private String name;
    private String surname;
    private String adress;

    public Person(String number, String name, String surname, String adress) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return number == person.number;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }

    public boolean contains(String offer) {
        if(this.getAdress().contains(offer) || this.getName().contains(offer) || this.getNumber().contains(offer) || this.getSurname().contains(offer)) {
            return true;
        }
        return false;
    }
}
