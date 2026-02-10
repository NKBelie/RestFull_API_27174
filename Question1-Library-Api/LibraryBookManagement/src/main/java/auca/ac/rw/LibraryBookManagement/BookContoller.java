package auca.ac.rw.LibraryBookManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookContoller {

    List<Book> books = new ArrayList<>();

    public BookContoller() {
        books.add(new Book(100L, "Java", "Jeremeh", "978-0743273565", 2019));
        books.add(new Book(102L, "Web Technology", "Partick", "978-0061120084", 2018));
        books.add(new Book(103L, "SPM", "Aimable", "978-0451524935", 2022));
    }
    
    @GetMapping
    public List<Book> getAllBooks(){
        return books;
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam String title){
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
    @PostMapping
    public Book addBook(@RequestBody Book book){
        books.add(book);
        return book;
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        books.removeIf(book -> book.getId().equals(id));
        System.out.println("Book with ID " + id + " has been deleted.");
    }
}
