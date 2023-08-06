package dev.liuyong1996.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// Let framework know this class represents each document in movies db
@Document(collection = "reviews")
@Data //This replaces writing setters and getters methods
@AllArgsConstructor //Creates a constructor that takes all the below private fields as arguments
@NoArgsConstructor //Creates a that takes no parameters.
// the above two annotations are basically to overload the constructors...
public class Review {
    @Id // Indicate to framework this is the unique identifier
    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Review(String body, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.created = created;
        this.updated = updated;
    }
}
