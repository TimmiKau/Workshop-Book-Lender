package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // todo: needs completion

        // Create a book instance
        Book bookOne = new Book("Java 101", "Elnaz Azizi");

        // Display book information
        System.out.println(bookOne.getInformation());

        // Create a person instance
        Person personOne = new Person("Timmi", "Karlsson");

        // Display person information
        System.out.println(personOne.getInformation());

        // Loan a book to the person
        personOne.loanBook(bookOne);

        // Display person information after borrowing a book
        System.out.println(personOne.getInformation());

        // Display book information after borrowing a book
        System.out.println(bookOne.getInformation());

        // Return the borrowed book
        personOne.returnBook(bookOne);

        // Display person information after returning the book
        System.out.println(personOne.getInformation());

        // Display book information after borrowing a book
        System.out.println(bookOne.getInformation());


        // After the assignment


        //Make many books
        Book bookJava = new Book("Java 101 - Part 1", "Elnaz Azizi");
        Book bookJava2 = new Book("Java 101 - Part 2", "Elnaz Azizi");
        Book bookJava3 = new Book("Java 101 - Part 3", "Elnaz Azizi");
        Book bookjava4 = new Book("Java 101 - Part 4", "Elnaz Azizi");
        Book bookjava5  = new Book("Java 101 - Part 5", "Elnaz Azizi");

        //New person
        Person marks = new Person("Marks", "Stevenson");

        //Test borrow multiple books
        marks.loanBook(bookJava);
        marks.loanBook(bookJava2);
        marks.loanBook(bookJava3);

        //See borrowed books
        System.out.println(marks.getInformation());

        //Return bookjava2
        marks.returnBook(bookJava2);

        //See borrowed books
        System.out.println(marks.getInformation());

    }

}
