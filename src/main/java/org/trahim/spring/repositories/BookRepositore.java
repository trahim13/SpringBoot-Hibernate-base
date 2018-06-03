package org.trahim.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.trahim.spring.domain.Book;

@Repository
public interface BookRepositore extends JpaRepository<Book, Long> {
    Page<Book> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

    @Query("SELECT b.content from Book b where b.id =:id")
    byte[] getContent(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Book b set b.content=:content where b.id=:id")
    void updateContent(@Param("content") byte[] content, @Param("id") Long id);

    @Query("select new ru.javabegin.training.springlibrary.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publisher, b.publishYear, b.image, b.descr) from Book b")
    Page<Book> findAllWithoutContent(Pageable pageable);
}
