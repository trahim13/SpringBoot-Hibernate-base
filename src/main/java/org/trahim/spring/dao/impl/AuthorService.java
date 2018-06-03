package org.trahim.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trahim.spring.dao.AuthorDao;
import org.trahim.spring.domain.Author;
import org.trahim.spring.repositories.AuthorRepository;

import java.util.List;


@Service
@Transactional
public class AuthorService implements AuthorDao {

        @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }


    @Override
    public Author get(long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public Author save(Author obj) {
        return authorRepository.save(obj);
    }

    @Override
    public void delete(Author object) {
        authorRepository.delete(object);

    }

    @Override
    public List<Author> search(String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0]);
    }





    // постраничный вывод
    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize,  String sortField, Sort.Direction sortDirection, String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }


}
