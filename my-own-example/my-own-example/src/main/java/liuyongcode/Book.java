package liuyongcode;
import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
public class Book {
    @Id //add unique id for each entry, default increment is 50 eg 1 51 101
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    private Integer id;
    private String Title;
    private String Publisher;
    private String publishedDate;
    private ArrayList<String> Genres;
    private ArrayList<String> Reviews = new ArrayList<>();
    private String bookStatus;
    private String bookUrl;
    private Integer numAvailable;


    public Book(Integer id,
                 String Title,
                 String Publisher,
                 String publishedDate,
                 ArrayList<String> Genres,
                 String bookStatus,
                 String bookUrl,
                 Integer numAvailable) {
        this.id = id;
        this.Title = Title;
        this.Publisher = Publisher;
        this.publishedDate = publishedDate;
        this.Genres = Genres;
        this.bookStatus = bookStatus;
        this.bookUrl = bookUrl;
        this.numAvailable = numAvailable;
    }

    public Book(){}

    public Integer getBookId(){return id;}
    public String getTitle(){return Title;}
    public String getPublisher(){return Publisher;}
    public String getPublishedDate(){return publishedDate;}
    public ArrayList<String> getGenres(){return Genres;}
    public ArrayList<String> getReviews(){return Reviews;}
    public String getBookStatus(){return bookStatus;}
    public String getBookUrl(){return bookUrl;}
    public Integer getNumAvailable(){return numAvailable;}

    public void setBookId(Integer bookId){this.id = bookId; }
    public void setTitle(String Title){this.Title = Title;}
    public void setPublisher(String Publisher){this.Publisher = Publisher;}
    public void setPublishedDate(String publishedDate){this.publishedDate = publishedDate;}
    public void setGenres(ArrayList<String> Genres){this.Genres = Genres;}
    public void addReviews(String review){Reviews.add(review);}
    public void setBookStatus(String bookStatus){this.bookStatus = bookStatus;}
    public void setBookUrl(String bookUrl){this.bookUrl = bookUrl;}
    public void setNumAvailable(Integer numAvailable){this.numAvailable = numAvailable;}


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + id +
                ", Publisher='" + Publisher + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", Genres=" + Genres + '\'' +
                ", Reviews=" + Reviews + '\'' +
                ", bookStatus=" + bookStatus + '\'' +
                ", bookUrl=" + bookUrl + '\'' +
                ", numAvailable=" + numAvailable + '\'' +
                '}';
    }

}
