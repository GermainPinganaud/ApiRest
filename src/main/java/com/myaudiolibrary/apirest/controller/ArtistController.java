package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.model.Artist;
import com.myaudiolibrary.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;


@RestController
@RequestMapping(value = "/artists")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    /**
     * findById
     * @param id
     * @return Artist
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}"
    )
    public Artist findById(@PathVariable(value = "id") Integer id) {
        return artistRepository.findById(id);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "",
            params = {
                    "name",
                    "page",
                    "size",
                    "sortDirection",
                    "sortProperty"})
    public Page<Artist> findByName(
        @RequestParam("name") String name,
        @RequestParam("page") Integer page,
        @RequestParam("size") Integer size,
        @RequestParam("sortDirection") String sortDirection,
        @RequestParam("sortProperty") String sortProperty){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return artistRepository.findByNameContains(name, pageRequest);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "",
            params = {
                    "page",
                    "size",
                    "sortDirection",
                    "sortProperty"})

    public Page<Artist> findAll(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("sortDirection") String sortDirection,
            @RequestParam("sortProperty") String sortProperty){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return artistRepository.findAll(pageRequest);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public Artist addArtist(@RequestBody Artist artist){
        return artistRepository.save(artist);
    }

}
