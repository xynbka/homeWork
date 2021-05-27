package ru.springdata.library.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.springdata.library.domain.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @EntityGraph(   type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {
                    "genres",
                    "comments"
            }
    )
    List<Book> findAll();

    @Query("SELECT B FROM Book B WHERE LOWER(B.name) LIKE LOWER(:name)")
    Optional<Book> findByName(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM Book B WHERE LOWER(B.name) LIKE LOWER(:name)")
    void deleteBookByName(@Param("name") String name);
}
