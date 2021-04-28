package optional;

import CompulsoryLab9.EntityClasses.Movies;
import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
/**
 * this class help us to create movies chart
 */
public class Chart {
    private String name;
    private Date creation_date;
    private List<Movies> moviesList = new LinkedList<>();
}
