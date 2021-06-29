package ru.springdata.library.repositories;

import org.hibernate.jpa.QueryHints;
import ru.springdata.library.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomBookRepoImpl implements CustomBookRepo {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Book> findAll() {
        String jpql = "SELECT DISTINCT B FROM Book B LEFT OUTER JOIN FETCH B.author";
        List<Book> books = em.createQuery(jpql,Book.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH,false).getResultList();
        jpql = "SELECT DISTINCT B from Book B left outer join fetch B.comments left outer join fetch B.genre where B in :books";
        books = em.createQuery(jpql, Book.class).setParameter("books", books).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH,false).getResultList();
        return books;
    }
}
