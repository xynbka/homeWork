package ru.springdata.library.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class BookServiceTest {
    @Autowired private BookService bookService;
    @Autowired private TestEntityManager testEntityManager;


    @Test
    public void findComments() {
    }
}
