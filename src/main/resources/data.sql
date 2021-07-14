insert into GENRE (GENRE_NAME) values ('приключениия');
insert into GENRE (GENRE_NAME) values ('боевик');
insert into GENRE (GENRE_NAME) values ('фантастика');

insert into AUTHOR (AUTHOR_NAME) values ('Роджер Желязны');
insert into AUTHOR (AUTHOR_NAME) values ('Толкиен');
insert into AUTHOR (AUTHOR_NAME) values ('Сергей Тормашев');

insert into BOOKS (BOOK_NAME,GENRE_ID,AUTHOR_ID) values ('Хроники Амбера',3,1);
insert into BOOKS (BOOK_NAME,GENRE_ID,AUTHOR_ID) values ('Братство кольца',1,2);
insert into BOOKS (BOOK_NAME,GENRE_ID,AUTHOR_ID) values ('Древний',2,3);
insert into BOOKS (BOOK_NAME,GENRE_ID,AUTHOR_ID) values ('Имя мне Легион',3,1);

insert into BOOK_AUTHOR (BOOK_ID, AUTHOR_ID) VALUES (1,1);
insert into BOOK_AUTHOR (BOOK_ID, AUTHOR_ID) VALUES (2,2);
insert into BOOK_AUTHOR (BOOK_ID, AUTHOR_ID) VALUES (3,3);
insert into BOOK_AUTHOR (BOOK_ID, AUTHOR_ID) VALUES (4,1);

insert into COMMENT (COMMENT, BOOK_ID) values ('Конченая шляпа!',2);
insert into COMMENT (COMMENT, BOOK_ID) values ('Шикарная книга!',4);
insert into COMMENT (COMMENT, BOOK_ID) values ('Превосходная книженция!!',4);