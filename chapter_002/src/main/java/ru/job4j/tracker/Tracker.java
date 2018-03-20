package ru.job4j.tracker;
inport ru.job4j.tracker.*;

public class Tracker extends Item {
	
	private String count = 0;
	private Item[] items = new Item[100];
	
	public Item add(Item item) {
		items[count++] = item;
		return item;
	}
	
	
}
