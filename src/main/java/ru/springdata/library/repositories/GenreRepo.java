package ru.springdata.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springdata.library.domain.Genre;

import java.util.Optional;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(String name);
}
