package edu.ajay;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  public List getAll() {
    return authorRepository.getAllAuthors();
  }

  public Author saveAuthor(Author author) {
    return authorRepository.save(author);
  }

  public Optional<Author> getAuthorById(Long id) {
    return authorRepository.findById(id);
  }

  public void deleteAuthor(Long id) {
    authorRepository.deleteById(id);
  }
  public void deleteAllAuthors() {
    authorRepository.deleteAll();
  }

  public Long getCountOfAuthors() {
    return authorRepository.count();
  }
}
