package ru.springdata.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springdata.library.domain.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
