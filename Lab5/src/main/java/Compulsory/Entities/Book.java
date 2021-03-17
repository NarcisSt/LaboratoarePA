package Compulsory.Entities;

import lombok.*;


@Getter
@Setter
@ToString
public class Book extends BaseItem {
    private String ISBN;

    @Builder
    public Book(String name, String path, String ISBN) {
        super(name, path);
        this.ISBN = ISBN;
    }
}
