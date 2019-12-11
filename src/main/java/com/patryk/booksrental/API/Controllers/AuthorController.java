package com.patryk.booksrental.API.Controllers;


import com.patryk.booksrental.API.Assemblers.AuthorResourceAssembler;
import com.patryk.booksrental.API.Resources.AuthorResource;
import com.patryk.booksrental.Models.Author;
import com.patryk.booksrental.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;
    private AuthorResourceAssembler authorResourceAssembler;

//    @RequestMapping(value = "/{someID}",produces = "application/json", method = RequestMethod.GET)
//    public AuthorResource getAuthor(@PathVariable(value="someID") long id){
//
//    }

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public List<AuthorResource> getAuthors(){
        List<AuthorResource> authorResources;
        List<Author> authorList = authorService.getAuthorList();
        authorResources = authorResourceAssembler.buildResources(authorList);
        return authorResources;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService){this.authorService = authorService;}

    @Autowired
    public void setAuthorResourceAssembler(AuthorResourceAssembler authorResourceAssembler){
        this.authorResourceAssembler = authorResourceAssembler;
    }
}
