package home.books.controller;

import home.books.model.Book;
import home.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/list")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/save")
    public Book createEmployee(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PostMapping("/delete/{id}")
    public Map< String, Boolean > deleteBook(@PathVariable(value = "id") Long bookId) throws Exception {
        Book employee = bookRepository.findById(bookId)
                .orElseThrow(() -> new Exception("Employee not found for this id :: " + bookId));

        bookRepository.delete(employee);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}


