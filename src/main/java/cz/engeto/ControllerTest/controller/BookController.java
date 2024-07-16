package cz.engeto.ControllerTest.controller;

import cz.engeto.ControllerTest.dto.Book;
import cz.engeto.ControllerTest.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<Book> getAllBooks() throws SQLException {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBooksById(@PathVariable int id) throws SQLException {
        return bookService.getBookById(id);
    }

    @PostMapping
    public void createBook(@RequestBody Book book) throws SQLException {
        bookService.createBook(book);
    }

}
