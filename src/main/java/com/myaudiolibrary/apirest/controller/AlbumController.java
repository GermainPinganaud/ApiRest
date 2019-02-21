package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Album addAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }

//    @RequestMapping(
//            method = RequestMethod.PUT,
//            consumes = "application/json",
//            produces = "application/json"
//    )
//    public Album updateArtist(@PathVariable(value = "id") Integer id, @RequestBody String title){
//        Artist artist = findById(id);
//        artistRepository.save(album);
//        album.setArtist(artist);
//        album.setTitle(title);
//        return artistRepository.save(album);
//    }
}
