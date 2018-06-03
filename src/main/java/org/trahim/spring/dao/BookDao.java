package org.trahim.spring.dao;

import org.trahim.spring.domain.Book;

public interface BookDao extends GeneralDAO<Book> {

    byte[] getContent(long id);
}
