package popova.collection.telephone;

import java.util.ArrayList;
import java.util.List;

public class TelephoneList {
    private List<Person> TelegponeStore = new ArrayList<>();

    public void add(Person person){
        this.TelegponeStore.add(person);
    }

    public List<Person> getList(String offer) {
        List<Person> list = new ArrayList<>();
        for (Person men: TelegponeStore) {
            if(men.contains(offer)) {
                list.add(men);
            }
        }
        return list;
    }
}
