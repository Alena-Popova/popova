package popova.tracker;
import popova.tracker.*;

public class StartUI {
	
	public static void main(String[] args) {
		
		Tracker reciver = new Tracker();
		Item first = new Item( "First", "test", 21);
		reciver.add(first);
		for (Item item : reciver.getAll()) {
			System.out.println(item.getName());
		}
	}
}