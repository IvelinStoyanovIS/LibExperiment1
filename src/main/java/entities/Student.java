package entities;

/**
 * Created by Ivelin Stoyanov on 14.5.2018 г..
 */
public class Student {


    private int id;
    private String name;
    private String courseNumb;
    private int readBooks;
    private String email;
    private String currentBook;
    private String PathImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseNumb() {
        return courseNumb;
    }

    public void setCourseNumb(String courseNumb) {
        this.courseNumb = courseNumb;
    }

    public int getReadBooks() {
        return readBooks;
    }

    public void setReadBooks(int readBooks) {
        this.readBooks = readBooks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrntBook() { return currentBook; }

    public void setCurrntBook(String currentBook) {
        this.currentBook = currentBook;
    }

    public String getPathImage() {
        return PathImage;
    }

    public void setPathImage(String pathImage) {
        PathImage = pathImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
