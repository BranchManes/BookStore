package com.artur.bookstore;

import com.artur.bookstore.model.*;

import java.util.ArrayList;

public class Main {
    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {

        Main.initData();
        String booksInfo = String.format("Общее количество проданных книг %d, на сумму %f",
                getCountBooks(), getAllPriceOfSoldBooks());
        System.out.println(booksInfo);


    }

    /**
     * Общая стоимость для всех заказов
     *
     * @return Cтоимость всех заказов
     */
    public static double getAllPriceOfSoldBooks() {
        double price = 0;
        for (Order order : orders) {
            price += getPriceOfSoldBooksInOrder(order);
        }
        return price;

    }

    /**
     * Общая стоимость для одного заказа
     *
     * @param order
     * @return Общая стоимость для одного заказа
     */

    public static double getPriceOfSoldBooksInOrder(Order order) {
        double price = 0;
        for (long bookId : order.getBooks()) {
            Book book = getBook(bookId);
            if (book != null) {
                price += book.getPrice();
            }
        }
        return price;
    }


    /**
     * Метод для подсчета количества всех проданных книг
     *
     * @return количество проданных книг
     */
    public static int getCountBooks() {
        int count = 0;
        for (Order order : orders) {
            count += order.getBooks().length;
        }
        return count;
    }


    /**
     * Метод для поиска нужной книги в списке книг по id книги
     *
     * @param id уникальный номер книги
     * @return найденная книга
     */
    public static Book getBook(long id) {
        Book container = null;
        for (Book book : books) {
            if (book.getId() == id) {
                container = book;
                break;

            }
        }
        return container;
    }


    public static void initData() // метод заполнения данных
    {
        // Продавцы
        employees.add(new Employee(1, "Maria Ivanova", 37));
        employees.add(new Employee(2, "Ivan Ivanov", 47));
        employees.add(new Employee(3, "Serg Ivanov", 57));

        // Покупатели
        customers.add(new Customer(1, "Sidorov Alex", 25));
        customers.add(new Customer(2, "Romanov Ivan", 32));
        customers.add(new Customer(3, "Simovon Eldar", 18));

        //Книги
        books.add(new Book(1, "Financist", "Teodor Draizer", 1600, BookGenre.Art));
        books.add(new Book(2, "War and Piece", "Tolstoy Lec", 1500, BookGenre.Art));


        books.add(new Book(3, "Dead soul", "Dostoevsky Fedor", 1300, BookGenre.Art));
        books.add(new Book(4, "Man and woman", "Fraid Zigmond", 1200, BookGenre.Psychology));
        books.add(new Book(5, "Manipulation and actualization", "Everett Shostorm", 1150, BookGenre.Psychology));
        books.add(new Book(6, "C++ start", "Zinich Roman", 1100, BookGenre.Programming));

        //Заказы
        orders.add(new Order(1, 1, 1, new long[]{1, 2, 3}));
        orders.add(new Order(2, 2, 2, new long[]{2, 3, 4}));
        orders.add(new Order(3, 3, 3, new long[]{4, 5, 6}));

    }
}
