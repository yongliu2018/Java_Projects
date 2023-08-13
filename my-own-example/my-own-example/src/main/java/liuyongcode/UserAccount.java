package liuyongcode;
import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
public class UserAccount {
    @Id //add unique id for each entry, default increment is 50 eg 1 51 101
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Integer id;
    private String Username;
    private String Password;
    private String Email;
    private String adminStatus;
    private String firstName;
    private String lastName;
    private ArrayList<Integer> booksBorrowed = new ArrayList<>();


    public UserAccount(Integer id,
                       String Username,
                       String Password,
                       String Email,
                       String adminStatus,
                       String firstName,
                       String lastName) {
        this.id = id;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.adminStatus = adminStatus;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserAccount(){}

    public Integer getUserId(){return id;}
    public String getUsername(){return Username;}
    public String getPassword(){return Password;}
    public String getEmail(){return Email;}
    public String getAdminStatus(){return adminStatus;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public ArrayList<Integer> getBooksBorrowed(){return booksBorrowed;}

    public void setUserId(Integer userId){this.id = userId; }
    public void setUsername(String Username){this.Username = Username;}
    public void setPassword(String Password){this.Password = Password;}
    public void setEmail(String Email){this.Email = Email;}
    public void setAdminStatus(String adminStatus){this.adminStatus = adminStatus;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void addBooksBorrowed(Integer bookId){booksBorrowed.add(bookId);}
    public void removeBooksBorrowed(Integer bookId){booksBorrowed.remove(bookId);}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email=" + Email + '\'' +
                ", adminStatus=" + adminStatus + '\'' +
                ", firstName=" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                ", booksBorrowed=" + booksBorrowed + '\'' +
                '}';
    }
}
