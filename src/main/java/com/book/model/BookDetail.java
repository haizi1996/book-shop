package com.book.model;

public class BookDetail extends Book {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "BookDetail{" +
                "categoryName='" + categoryName + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
