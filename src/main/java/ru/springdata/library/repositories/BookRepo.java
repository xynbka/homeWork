package ru.springdata.library.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springdata.library.domain.Book;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @EntityGraph(   type = EntityGraph.EntityGraphType.FETCH,
                    attributePaths = {
                            "comments"
                        }
                    )
    Optional<Book> findById(Long id);

}
