package entities;

/**
 * Created by Ivelin Stoyanov on 9.5.2018 г..
 */
public class Books {
    private int id;
    private String BookBarcode;
    private String BookName;
    private String BookAutor;
    private String BookGenre;
    private String BookPublisher;
    private String BookDescription;
    private String BookDate;
    private String BookImage;
    private String PathImage;


    //public Books(){

    //}
    //public Books(String bookName, String bookAutor, String bookGenre, String bookPublisher, String bookDescription, String bookDate, String bookImage, String PathImage) {

    //}


    public String getBookBarcode() {
        return BookBarcode;
    }

    public void setBookBarcode(String bookBarcode) {
        BookBarcode = bookBarcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookAutor() {
        return BookAutor;
    }

    public void setBookAutor(String bookAutor) {
        BookAutor = bookAutor;
    }

    public String getBookGenre() {
        return BookGenre;
    }

    public void setBookGenre(String bookGenre) {
        BookGenre = bookGenre;
    }

    public String getBookPublisher() {
        return BookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        BookPublisher = bookPublisher;
    }

    public String getBookDescription() {
        return BookDescription;
    }

    public void setBookDescription(String bookDescription) {
        BookDescription = bookDescription;
    }

    public String getBookDate() {
        return BookDate;
    }

    public void setBookDate(String bookDate) {
        BookDate = bookDate;
    }

    public String getBookImage() {
        return BookImage;
    }

    public void setBookImage(String bookImage) {
        BookImage = bookImage;
    }

    public String getPathImage() { return PathImage; }

    public void setPathImage(String pathImage) { PathImage = pathImage; }

}
