package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Album addAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }
}
