package ru.springdata.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.springdata.library.domain.Author;

import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

    @Query("SELECT a from Author a where LOWER(a.name) like  LOWER(:name)")
    Optional<Author> findByName(@Param("name") String name);
}
