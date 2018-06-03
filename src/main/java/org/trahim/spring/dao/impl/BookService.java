package org.trahim.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trahim.spring.dao.BookDao;
import org.trahim.spring.domain.Book;
import org.trahim.spring.repositories.BookRepositore;

import java.util.List;

@Service
@Transactional
public class BookService implements BookDao {

    @Autowired
    private BookRepositore bookRepository;


    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllWithoutContent(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public List<Book> search(String... searchString) {
        return null;
    }


    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return bookRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }


    @Override
    public Book save(Book book) {
        bookRepository.save(book);

        if (book.getContent()!=null) {
            bookRepository.updateContent(book.getContent(), book.getId());
        }

        return book;

    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book get(long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContent(id);
    }
}
