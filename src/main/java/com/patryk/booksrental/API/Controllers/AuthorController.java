package com.patryk.booksrental.API.Controllers;


import com.patryk.booksrental.API.Assemblers.AuthorResourceAssembler;
import com.patryk.booksrental.API.Resources.AuthorResource;
import com.patryk.booksrental.Models.Author;
import com.patryk.booksrental.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;
    private AuthorResourceAssembler authorResourceAssembler;

    @RequestMapping(value = "/{someID}",produces = "application/json", method = RequestMethod.GET)
    public AuthorResource getAuthor(@PathVariable(value="someID") long id){
        Author author = authorService.getAuthorById(id);
        return authorResourceAssembler.buildResource(author);
    }

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public List<AuthorResource> getAuthors(){
        List<Author> authorList = authorService.getAuthorList();
        return authorResourceAssembler.buildResources(authorList);
    }

    @RequestMapping(value = "/name", produces = "application/json", method = RequestMethod.GET)
    public List<AuthorResource> getAuthorsByName(@RequestParam(required = true) String name){
        List<Author> authorList = authorService.getAuthorsByName(name);
        return authorResourceAssembler.buildResources(authorList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addAuthor(@RequestBody(required = true) Author author){
        authorService.addAuthor(author);
        return new ResponseEntity<>("Dodano", HttpStatus.OK);
    }

    @Autowired
    public void setAuthorService(AuthorService authorService){this.authorService = authorService;}

    @Autowired
    public void setAuthorResourceAssembler(AuthorResourceAssembler authorResourceAssembler){
        this.authorResourceAssembler = authorResourceAssembler;
    }
}
