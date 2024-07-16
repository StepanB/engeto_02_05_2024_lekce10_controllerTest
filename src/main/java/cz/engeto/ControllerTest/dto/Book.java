package cz.engeto.ControllerTest.dto;

import java.util.Date;

public class Book {

    private int id;
    private String title;
    private String genre;
    private int authorId;
    private String publishedDate;
    private String authorName;

    public Book() {
    }

    public Book(int id, String title, String genre, int authorId, String publishedDate) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
        this.publishedDate = publishedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
