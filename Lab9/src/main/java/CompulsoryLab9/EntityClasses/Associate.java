package CompulsoryLab9.EntityClasses;

import javax.persistence.*;

@Entity
@Table(name = "ASSOCIATE")
public class Associate {
    @Column(name = "ID_MOVIE")
    private Long idMovie;

    @Column(name = "ID_GENRE")
    private Long idGenre;
    @Id
    private Long id;

    public Long getIdMovie() {
        return this.idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public Long getIdGenre() {
        return this.idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
