package cn.edu.sdut.softlab.hibernate.tutorial;

import java.util.Date;

public class Article {

  private Long id;

  private String title;
  private Date date;

  public Article() {
    //@TODO this form used by Hibernate ?
  }

  public Article(String title, Date date) {
    this.title = title;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  private void setId(Long id) {
    this.id = id;
  }

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
