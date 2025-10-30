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
        personOne.returnBook();

        // Display person information after returning the book
        System.out.println(personOne.getInformation());

        // Display book information after borrowing a book
        System.out.println(bookOne.getInformation());
    }

}
