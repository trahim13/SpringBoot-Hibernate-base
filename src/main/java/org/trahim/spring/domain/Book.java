package org.trahim.spring.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table (name="book", catalog = "library")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Setter @Getter
@EqualsAndHashCode(of = "id")
public class Book {

    public Book() {
    }



    public Book(Long id, String name, Integer pageCount, String isbn, Genre genre, Author author, Publisher publisher, Integer publishYear, byte[] image, String descr) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.image = image;
        this.descr = descr;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name="content", updatable = false)
    private byte[] content;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "isbn")
    private String isbn;

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @Column(name = "publish_year")
    private Integer publishYear;


    @Column(name = "image")
    private byte[] image;

    @Column(name = "descr")
    private String descr;

    @Override
    public String toString() {
        return name;
    }
}
