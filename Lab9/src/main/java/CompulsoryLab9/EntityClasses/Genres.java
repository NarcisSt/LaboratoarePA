package CompulsoryLab9.EntityClasses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@Accessors(chain = true)
@Data
@Entity
@Table(name = "GENRES")
/**
 * Genres class as Entity imported from our OracleDB
 */
public class Genres {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME")
    private String name;

    public Genres(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genres() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
