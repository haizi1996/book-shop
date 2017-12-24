package com.book.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//������Ϣ����Ӧ�ľ��ǹ��ﳵ�Ļ�����Ϣ
public class Orders implements Serializable{
	private String id;
	private String ordernum;//�����š�notnull  unique
	private int num;//����
	private float price;//������
	
	private List<OrdersItem> items = new ArrayList<OrdersItem>();//�����еĶ�����
	
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrdersItem> getItems() {
		return items;
	}

	public void setItems(List<OrdersItem> items) {
		this.items = items;
	}
	
	
}
