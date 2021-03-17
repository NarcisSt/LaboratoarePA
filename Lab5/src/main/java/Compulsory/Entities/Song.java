package Compulsory.Entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Song extends BaseItem {
    private String author;

    @Builder
    public Song(String name, String path, String author) {
        super(name, path);
        this.author = author;
    }
}
