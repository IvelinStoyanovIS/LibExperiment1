package entities;

/**
 * Created by Ivelin Stoyanov on 14.5.2018 г..
 */
public class Student {
    private String name;
    private String facNum;
    private int numberReadBooks;
    private String email;
    private boolean takenBook;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacNum() {
        return facNum;
    }

    public void setFacNum(String facNum) {
        this.facNum = facNum;
    }

    public int getNumberReadBooks() {
        return numberReadBooks;
    }

    public void setNumberReadBooks(int numberReadBooks) {
        this.numberReadBooks = numberReadBooks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTakenBook() {
        return takenBook;
    }

    public void setTakenBook(boolean takenBook) {
        this.takenBook = takenBook;
    }
}
