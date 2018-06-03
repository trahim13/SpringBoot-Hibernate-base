package org.trahim.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trahim.spring.domain.Genre;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findByNameContainingIgnoreCaseOrderByName(String name);

    Page<Genre> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);
}
