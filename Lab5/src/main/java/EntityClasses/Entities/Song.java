package EntityClasses.Entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

/**
 * The class Song extends class BaseItem, a song have an author.
 */
public class Song extends BaseItem {
    private String author;

    @Builder
    public Song(String name, String path, String author) {
        super(name, path);
        this.author = author;
    }
}
