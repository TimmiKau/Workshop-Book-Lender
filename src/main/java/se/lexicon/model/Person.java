package se.lexicon.model;

public class Person {

    private int sequencer= 0;
    private int id ;
    private String firstName;
    private String lastName;
    private Book book;

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
        this.book = book;
        book.setPerson(this);
    }

    //Return book
    public void returnBook() {
        book.returnBook();
        this.book = null;
     }

    //getPersonInformation
    public String getInformation() {
        return "id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", book: " + (book != null? book.getInformation() : "Has no borrowed book");
    }
}