package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class VisitLibary {
    public static void main(String[] args) {

        while (true) {
            // Add the books ( This could later be a database
            //Make many books
            ArrayList<Book> books = new ArrayList<Book>();
            books.add(new Book("Java 101 - Part 1", "Elnaz Azizi"));
            books.add(new Book("Java 101 - Part 2", "Elnaz Azizi"));
            books.add(new Book("Java 101 - Part 3", "Elnaz Azizi"));
            books.add(new Book("Java 101 - Part 4", "Elnaz Azizi"));
            books.add(new Book("Java 101 - Part 5", "Elnaz Azizi"));

            //Scanner
            Scanner scanner = new Scanner(System.in);

            // Welcome text
            System.out.println("Welcome to Book Lender");

            // Ask for name ( Get if already exist? )
            System.out.println("What is your FirstName?");
            String firstName = scanner.next();
            System.out.println("What is your LastName?");
            String lastName = scanner.next();

            Person person = new Person(firstName, lastName);
            System.out.println("Welcome " + person.getFirstName() + " " + person.getLastName());

            boolean logOut = true;
            while (logOut) {

                //Do you want to return or borrow a book
                System.out.println("Do you want to \n1. loan \n2. return book? \n3. Logout?");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        //Call all books method
                        chooseBookToLoan(books, scanner, person);
                        break;
                    }
                    case 2: {
                        returnBook(books, scanner, person);
                        break;
                    }
                    case 3: {
                        logOut = false;
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice");
                        break;
                    }
                }
            }
        }


    }

    public static String loanBook(ArrayList<Book> books) {

        String available = "Available: \n";
        String borrowed = "Borrowed: \n";

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);


            if (book.isAvailable()) {

                available += (i + 1 ) + ". " + book.getTitle() + book.getAuthor() +  "\n";

            } else {

                borrowed += book.getTitle() + book.getAuthor() + "\n";

            }
        }

        return (!available.isEmpty() ? available : "No books Available") + (!borrowed.isEmpty() ? borrowed  : " ");
    }

    public static void chooseBookToLoan (ArrayList<Book> books,Scanner scanner, Person person) {

        System.out.println(loanBook(books));
        System.out.println("Choose a number:");

        int bookChoice = scanner.nextInt() - 1;
        Book chosenBook = books.get(bookChoice);
        person.loanBook(chosenBook);

        System.out.println(person.getInformation());
    }

    public static void returnBook(ArrayList<Book> books, Scanner scanner, Person person) {

        System.out.println("Your books:");
        ArrayList<Book> borrowedBooks = person.getBookList();

        if (borrowedBooks.isEmpty()) {
            System.out.println("You have no borrowed books.");
            return;
        }

        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + borrowedBooks.get(i).getTitle());
        }

        System.out.println("Which book would you like to return?");
        int bookChoice = scanner.nextInt() - 1;

        if (bookChoice >= 0 && bookChoice < borrowedBooks.size()) {
            Book book = borrowedBooks.get(bookChoice);
            person.returnBook(book);
            System.out.println("You have returned: " + book.getTitle());
        } else {
            System.out.println("Invalid choice.");
        }

    }

}
