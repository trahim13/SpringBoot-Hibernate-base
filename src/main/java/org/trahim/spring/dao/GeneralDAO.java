package org.trahim.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GeneralDAO<T> {

    List<T> getAll();

    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

    List<T> search(String... searchString);

    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString);

    T get(long id);

    T save(T obj);

    void delete(T object);

}
