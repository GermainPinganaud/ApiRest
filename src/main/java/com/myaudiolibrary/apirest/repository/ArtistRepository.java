package com.myaudiolibrary.apirest.repository;

import com.myaudiolibrary.apirest.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistRepository extends PagingAndSortingRepository<Artist,Integer> {
    Artist findById(Integer id);

    Artist save(String name);

    void delete(Artist artist);

    Page<Artist> findByNameContains(String name, Pageable pageable);

    Page<Artist> findAll(Pageable pageable);
}
