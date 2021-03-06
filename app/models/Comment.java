package models;

import org.hibernate.annotations.ManyToAny;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by zyw on 2016/5/31.
 */
@Entity
public class Comment extends Model {

    @Required
    public String author;

    @Required
    public Date postedAt;

    @Lob
    @Required
    @MaxSize(1000)
    public String content;

    @Required
    @ManyToOne
    public Post post;

    public Comment(Post post, String author, String content) {

        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    }

}

