package cz.engeto.ControllerTest.service;

import cz.engeto.ControllerTest.dto.Book;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/engeto";

    private Statement getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING, "root", "heslo123");

        return connection.createStatement();
    }

    public List<Book> getAllBooks() throws SQLException {

        Statement statement = getConnection();

        ResultSet resultSet = statement.executeQuery("select * from books");

        List<Book> books = new ArrayList<>();
        while(resultSet.next()) {
            Book book = new Book();
            book.setTitle(resultSet.getString("title"));
            book.setGenre(resultSet.getString("genre"));
            book.setPublishedDate(resultSet.getString("published_date"));
            book.setAuthorId(resultSet.getInt("author_id"));

            books.add(book);
        }

        return books;
    }

    public Book getBookById(int id) throws SQLException {

        Statement statement = getConnection();

        ResultSet resultSet = statement.executeQuery("select b.*, a.first_name, a.last_name  from books b join authors a on b.author_id = a.id where b.id = " + id);

        Book book = new Book();
        while (resultSet.next()) {
            book.setId(resultSet.getInt(1));
            book.setTitle(resultSet.getString(2));
            book.setGenre(resultSet.getString(4));
            book.setAuthorId(resultSet.getInt(3));
            book.setPublishedDate(resultSet.getString(5));
            book.setAuthorName(resultSet.getString(6) + " " + resultSet.getString(7));
        }

        return book;
    }

    public void createBook(Book book) throws SQLException {
        Statement statement = getConnection();

        Boolean result = statement.execute("INSERT INTO Books (title, author_id, genre) " +
                "VALUES ('" + book.getTitle() + "', " + book.getAuthorId() + ", '" + book.getGenre() + "');");


    }
}
