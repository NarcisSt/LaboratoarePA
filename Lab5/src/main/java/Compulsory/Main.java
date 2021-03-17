package Compulsory;

import Compulsory.Entities.Book;

public class Main {
    public static void main(String[] args) {
        Catalog catalog =  new Catalog();

        Book book = new Book("Ion", "C:\\Users\\Narcis\\OneDrive\\Desktop\\Lab5PA\\Ion.txt", "232414");
//        catalog.add(book);

        catalog.load("C:\\Users\\Narcis\\OneDrive\\Desktop\\Lab5PA\\save.txt");
        catalog.play(book);
    }
}
