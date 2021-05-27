package ru.springdata.library.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import ru.springdata.library.domain.Comment;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(BookService.class)
public class BookServiceTest {

    @Autowired private BookService bookRepo;
    @Autowired private TestEntityManager testEntityManager;

    @Test
    public void findComments() {
        Comment comment = testEntityManager.find(Comment.class, 1l);
        bookRepo.findComments(2l);
        System.out.println(comment);
    }
}
