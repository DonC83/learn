package spittr.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by donovan on 15/06/08.
 */
@Entity
public class Spittle {

    private Spittle() {}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "spittr")
    private Spitter spitter;

    @Column
    private String message;

    @Column
    private Date postedTime;

    public Spittle(Long id, Spitter spitter, String message, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getPostedTime() {
        return this.postedTime;
    }

    public Spitter getSpitter() {
        return this.spitter;
    }

}
