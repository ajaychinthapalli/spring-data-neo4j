package edu.ajay;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends Neo4jRepository<Author, Long> {

  @Query("MATCH (au:Author)<-[a:AUTHORED]-(b:Book) RETURN au,a,b")
  List<Author> getAllAuthors();
}
