package Compulsory.Entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

/**
 * The class Movie extends class BaseItem, a movie have a producer.
 */
public class Movie extends BaseItem {
    private String producer;

    @Builder
    public Movie(String name, String path, String producer) {
        super(name, path);
        this.producer = producer;
    }
}
