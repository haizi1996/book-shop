package com.book.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category  {
	private Integer id;
	private String name;
	private String description;
	private List<Book> books = new ArrayList<Book>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}


	@Override
	public String toString() {
		return "Category{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", books=" + books +
				'}';
	}
}
