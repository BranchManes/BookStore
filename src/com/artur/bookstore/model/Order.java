package com.artur.bookstore.model;

public class Order {
    private long id;
    private  long customerId; // хранится id кому продали заказ (ID покупателя)
    private  long employeeId; // хранится id продавца
    private long [] books; // список номер которые продали

    public Order(long id, long customerId, long employeeId, long[] books) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long[] getBooks() {
        return books;
    }

    public void setBooks(long[] books) {
        this.books = books;
    }
}
