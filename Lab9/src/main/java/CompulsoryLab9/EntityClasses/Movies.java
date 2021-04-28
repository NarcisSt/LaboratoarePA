package CompulsoryLab9.EntityClasses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Accessors(chain = true)
@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "MOVIES")
@NamedQueries({
        @NamedQuery(name = "Movies.findByName",
                query = "SELECT m FROM Movies m WHERE m.name = :name")
})
/**
 * Movies class as Entity imported from our OracleDB
 */
public class Movies {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "DURATION")
    private Long duration;

    @Column(name = "SCORE")
    private Long score;

    public Movies(Long id, String title, Long duration, Long score) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.score = score;
    }

    public Movies() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getScore() {
        return this.score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

}
