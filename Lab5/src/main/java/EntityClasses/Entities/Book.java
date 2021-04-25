package EntityClasses.Entities;

import lombok.*;


@Getter
@Setter
@ToString

/**
 * The class Book extends class BaseItem, a song have a ISBN.
 */
public class Book extends BaseItem {
    private String ISBN;

    @Builder
    public Book(String name, String path, String ISBN) {
        super(name, path);
        this.ISBN = ISBN;
    }
}
