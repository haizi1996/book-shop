package com.book.model;

import java.util.HashMap;
import java.util.Map;

public class Cart  {
	private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();
	private int num;
	private float price;
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	
	public int getNum() {
		num = 0;
		for(Map.Entry<Integer, CartItem> me:items.entrySet()){
			num+=me.getValue().getNum();
		}
		return num;
	}

	public float getPrice() {
		price = 0;
		for(Map.Entry<Integer, CartItem> me:items.entrySet()){
			price+=me.getValue().getPrice();
		}
		return price;
	}


	public void addBook(Book book) {
		if(items.containsKey(book.getId())){
			CartItem item = items.get(book.getId());
			item.setNum(item.getNum()+1);
		}else{
			CartItem item = new CartItem();
			item.setBook(book);
			item.setNum(1);
			items.put(book.getId(), item);
		}
	}
	
}
