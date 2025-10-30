package se.lexicon.model;

import java.util.ArrayList;

public class Person {

    private int sequencer= 0;
    private int id ;
    private String firstName;
    private String lastName;
    private ArrayList<Book> books= new ArrayList<Book>();

    //Constructor
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setId();
    }

    //Getters and Settlers
    public int getId() {
        return id;
    }

    private void setId() {
        this.id = ++sequencer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Loan book
    public void loanBook(Book book) {
        books.add(book);
        book.setPerson(this);
    }

    //Return book
    public void returnBook(Book book) {
        book.returnBook();
        String bookTitle = book.getTitle();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(bookTitle)) {
                books.remove(i);
            }
        }
     }

    public String getBooks () {

        String result = "\n";
        for (Book book : books) {
            if(book!= null){
                result += book.getInformation() + "\n";
            }
        }

        return result.isEmpty() ? "No books borrowed" : result;
    }

    //getPersonInformation
    public String getInformation() {
        return "Id: " + id + ", FirstName: " + firstName + ", LastName: " + lastName + ", Books: " + (books.isEmpty() ?  "Has no borrowed book" : getBooks());
    }
}