package cn.edu.sdut.softlab.hibernate.tutorial;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "articles")
public class Article {

  private Long id;

  private String title;
  private Date date;

  // A must have!
  public Article() {
    // this form used by Hibernate
  }

  public Article(String title, Date date) {
    // for application use, to create new articles
    this.title = title;
    this.date = date;
  }

  @Id
  @GeneratedValue(generator = "sequence")
  @GenericGenerator(name = "sequence", strategy = "sequence")
  public Long getId() {
    return id;
  }

  private void setId(Long id) {
    this.id = id;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "time_created")
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "Article [id=" + id + ", title=" + title + ", date=" + date + "]";
  }

}
