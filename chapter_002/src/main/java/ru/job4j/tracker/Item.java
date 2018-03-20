package ru.job4j.tracker;

/**
* Класс реализации описания заявки
*@author Helena
*@sinse 1.0 20/03/18
*/
public class Item {
	
	private String id;
	private String name;
	private String desc;
	private long created;
	private String[] comments;
	
	public void setId(String aId) {
		this.id = aId;
	}
	
	public void setName(String aName) {
		this.name = aName;
	}
	
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void setComments(String[] aComments) {
		for (int count = 0; count < aComments.lenth; count++) {
		this.comments[count] = aComments[count];
		}

	}
	
	public String[] getComments() {
		return this.comments;
	}

}