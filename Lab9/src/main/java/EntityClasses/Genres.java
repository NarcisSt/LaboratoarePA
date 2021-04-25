package EntityClasses;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "GENRES")
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

    public String getID() {
        return this.ID;
    }

    public String getNAME() {
        return this.NAME;
    }

    public Genres setID(String ID) {
        this.ID = ID;
        return this;
    }

    public Genres setNAME(String NAME) {
        this.NAME = NAME;
        return this;
    }
}
