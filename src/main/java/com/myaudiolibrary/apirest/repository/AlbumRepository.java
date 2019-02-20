package com.myaudiolibrary.apirest.repository;

import com.myaudiolibrary.apirest.model.Album;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AlbumRepository extends PagingAndSortingRepository<Album,Integer> {
    List<Album> findByTitle(String title);


}
