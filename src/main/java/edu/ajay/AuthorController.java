package edu.ajay;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @PostMapping("/add")
  public Author addAuthor(@RequestBody Author author) {
    return authorService.saveAuthor(author);
  }

  @GetMapping("/{id}")
  public Author getAuthorById(@PathVariable String id) {
    Optional authorOpt = authorService.getAuthorById(Long.parseLong(id));
    throw new NoSuchElementException("No author found with given id.");
  }

  @GetMapping
  public Collection getAllAuthors() {
    return authorService.getAll();
  }

  @GetMapping("/count")
  public Long getCountofAuthors() {
    return authorService.getCountOfAuthors();
  }

  @DeleteMapping("/{id}")
  public String deleteAuthorById(@PathVariable String id) {
    authorService.deleteAuthor(Long.parseLong(id));
    return "Author deleted successfully";
  }

  @DeleteMapping
  public String deleteAllAuthors() {
    authorService.deleteAllAuthors();
    return "All Authors deleted successfully";
  }
}
