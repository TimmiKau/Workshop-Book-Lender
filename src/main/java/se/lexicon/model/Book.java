package se.lexicon.model;

import java.util.UUID;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person person;

    public Book(String title, String author) {
        setTitle(title);
        setAuthor(author);
        this.available = true;
        setId();
    }

    //Getter and Settler
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private void setId() {
        this.id = UUID.randomUUID().toString();
    }

    //Get book information
    public String getInformation(){
        return "Title: "+title+" Author: "+author+" Available: "+available + (person != null ? " Borrowed by: " + person.getFirstName() + " " +person.getLastName() : "None has borrowed this book");
    }

    //Get person borrowed book
    public Person getPerson() {
        return person;
    }

    //set a borrowed person
    public void setPerson(Person person) {
        this.person = person;
        this.available = (person == null);
    }

    //Return book
    public void returnBook(){
        this.available = (person != null);
    }
}