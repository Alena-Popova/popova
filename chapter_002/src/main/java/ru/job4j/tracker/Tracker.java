package popova.tracker;
import java.util.*;

public class Tracker extends Item {
	
	private int count = 0;
	private Item[] items = new Item[100];
	private static final Random RM = new Random();
	
	public Item add(Item item) {
		item.setId(this.generateId());
		items[count++] = item;
		return item;
	}
	
	static String generateId() {
		return String.valueOf(System.currentTimeMillis() + RM.nextInt());
	}
	
	
	public void replace(String id, Item item) {
		for (int i = 0; i < count; i++) {
			if (this.items[i].getId().equals(id)) {
				this.items[i] = item;
				this.items[i].setId(id);
			}
		}
	}
	
	public void delete(String id) {
		for (int i = 0; i < count; i++) {
			if(this.items[i].getId().equals(id)){
				this.items[i] = null;
				System.arraycopy(this.items, i + 1, this.items, i, count - i - 1);
				this.items[count-1] = null;
				count--;
			}
		}
	}
	
	public Item[] findAll() {
		Item[] itemsCopy = Arrays.copyOf(this.items,count);
		int index = count;
		int cCopy = 0;
		for (int i = 0; i < index; i++) {
			if (itemsCopy[i].getCreated()!= 0 && !(itemsCopy[i].getDescription().equals(""))) {
				System.arraycopy(itemsCopy, i, itemsCopy, cCopy++, 1);
			}
		}
		return Arrays.copyOf(itemsCopy,cCopy);
	}
	
	public Item[] findByName(String key) {
		Item[] itemsCopy = new Item[100];
		itemsCopy[0]  = Item.EMPTY;
		int cCopy = 0;
		for (int i = 0; i < count; i++) {
			if(this.items[i].getName(). equals(key)){
				System.arraycopy(this.items, i, itemsCopy, cCopy++, 1);
			}
		}
		return cCopy > 0 ? Arrays.copyOf(itemsCopy,cCopy) : Arrays.copyOf(itemsCopy,1);
	}

	public Item findById(String id) {
		Item findItem = null; // а мне говорили,что так делать нельзя
		for(Item offer : items) {
			if (offer != null && offer.getId().equals(id)) {
				findItem = offer;
				break;
			}
		}
		
		return findItem;
	}
	
	public Item[] getAll() {
		return Arrays.copyOf(this.items,count);
	}

	public int getCount() {
		return this.count;
	}

	public void exit() {

		System.out.println("Вы вышли");
		System.exit(0);
	}
}
