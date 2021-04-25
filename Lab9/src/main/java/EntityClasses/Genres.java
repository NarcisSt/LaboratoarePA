package EntityClasses;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "GENRES")
@NamedQueries({
        @NamedQuery(name = "Genres.findById",
                query = "SELECT g FROM Genres g WHERE g.ID=:id"),
        @NamedQuery(name = "Genres.findByName",
                query = "SELECT g FROM Genres g WHERE g.NAME=:NAME"),
        @NamedQuery(name = "Genres.create",
                query = "INSERT INTO Genres g (g.ID, g.NAME) VALUES(:id, :name)")
})
public class Genres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    private String ID;
    @Column(name = "NAME")
    private String NAME;
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

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
