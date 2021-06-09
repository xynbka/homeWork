package ru.springdata.library.repositories;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.springdata.library.domain.Book;

import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

//    @EntityGraph(   type = EntityGraph.EntityGraphType.FETCH,
//            attributePaths = {
//                    "genres",
//                    "comments"
//            }
//    )
    @EntityGraph(value = "bookGraphAll", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Book> findById(Long id);

    @EntityGraph(value = "bookGraphAll", type = EntityGraph.EntityGraphType.FETCH)
    List<Book> findAll();

    @Query("SELECT B FROM Book B WHERE LOWER(B.name) LIKE LOWER(:name)")
    Optional<Book> findByName(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM Book B WHERE LOWER(B.name) LIKE LOWER(:name)")
    void deleteBookByName(@Param("name") String name);
}
