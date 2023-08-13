package liuyongcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication //turn this class into a spring boot application
@RestController // Enable use of @GetMapping and @PostMapping to call methods
@RequestMapping("/api/v1")

public class Main {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public Main(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/users")
    public List<UserAccount> getUser() {return userRepository.findAll(); }
    record NewUserRequest(
            String Username,
            String Password,
            String Email,
            String adminStatus,
            String firstName,
            String lastName,
            ArrayList<Integer> booksBorrowed
    ){}

    @GetMapping("/books")
    public List<Book> getBook(){
        return bookRepository.findAll();
    }
    record NewBookRequest(
            String Title,
            String Publisher,
            String publishedDate,
            ArrayList<String> Genres,
            String bookStatus,
            String bookUrl,
            Integer numAvailable
    ){}

    @PostMapping("/add-user")
    public void addUser(@RequestBody NewUserRequest request){
        UserAccount user = new UserAccount();
        user.setUsername(request.Username());
        user.setPassword(request.Password());
        user.setEmail(request.Email());
        user.setAdminStatus(request.adminStatus());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        userRepository.save(user);
    }

    @PostMapping("/add-book")
    public void addUser(@RequestBody NewBookRequest request){
        Book book = new Book();
        book.setTitle(request.Title());
        book.setPublisher(request.Publisher());
        book.setPublishedDate(request.publishedDate());
        book.setGenres(request.Genres());
        book.setBookStatus(request.bookStatus());
        book.setBookUrl(request.bookUrl());
        book.setNumAvailable(request.numAvailable());
        bookRepository.save(book);
    }

}
