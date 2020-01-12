package com.patryk.booksrental.API.Controllers;


import com.patryk.booksrental.API.Assemblers.UserResourceAssembler;
import com.patryk.booksrental.API.Resources.UserResource;
import com.patryk.booksrental.Models.User;
import com.patryk.booksrental.Models.UserType;
import com.patryk.booksrental.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserResourceAssembler userResourceAssembler;

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public List<UserResource> getUserList(){
        List<User> userList = userService.getList();
        return userResourceAssembler.buildResources(userList);
    }

    @RequestMapping(value = "/{someID}", produces = "application/json", method = RequestMethod.GET)
    public UserResource getUserById(@PathVariable(value = "someID") long id){
        User user = userService.getUserById(id);
        return userResourceAssembler.buildResource(user);
    }

    @RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.GET)
    public List<UserResource> getUserByLogin(@RequestParam String login){
        List<User> userList = userService.getUserByLogin(login);
        if(userList.size() != 0){
            return userResourceAssembler.buildResources(userList);

        }else{
            return new ArrayList<UserResource>();
        }
    }

    @RequestMapping(value = "/email", produces = "application/json", method = RequestMethod.GET)
    public List<UserResource> getUserByEmail(@RequestParam String email){
        List<User> userList  = userService.getUserByEmail(email);
        if(userList.size() != 0){
            return userResourceAssembler.buildResources(userList);

        }else{
            return new ArrayList<UserResource>();
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User user){
        List<User> userLogin = userService.getUserByLogin(user.getLogin());
        if(userLogin.size() != 0){
            return new ResponseEntity<>("Login zajęty", HttpStatus.FORBIDDEN);
        }
        List<User> userEmail = userService.getUserByEmail(user.getEmail());
        if(userEmail.size() != 0){
            return new ResponseEntity<>("Email zajęty", HttpStatus.FORBIDDEN);
        }
        userService.addUser(user);
        return new ResponseEntity<>("Pomyślnie dodano", HttpStatus.OK);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public ResponseEntity<String> updatePassword(@RequestParam long id,
                                                 @RequestParam String password){
        userService.updatePassword(id, password);
        return new ResponseEntity<>("Pomślnie zmieniono hasło", HttpStatus.OK);
    }

    @RequestMapping(value = "/updateEmail", method = RequestMethod.POST)
    public ResponseEntity<String> updateEmail(@RequestParam long id,
                                                 @RequestParam String email){
        userService.updateEmail(id, email);
        return new ResponseEntity<>("Pomślnie zmieniono email", HttpStatus.OK);
    }


    @RequestMapping(value = "/updateUserType", method = RequestMethod.POST)
    public ResponseEntity<String> updateUserType(@RequestParam long id,
                                                 @RequestParam String userType){
        UserType userTypeEnum = UserType.valueOf(userType);
        userService.updateUserType(id, userTypeEnum);
        return new ResponseEntity<>("Pomślnie zmieniono uprawnienia", HttpStatus.OK);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> updatePassword(@RequestParam long id,
                                                 @RequestBody User user){
        userService.updateUser(id ,user);
        return new ResponseEntity<>("Pomślnie zaktualizowano użytkownika", HttpStatus.OK);
    }

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @Autowired
    public void setUserResourceAssembler(UserResourceAssembler userResourceAssembler){this.userResourceAssembler = userResourceAssembler;}
}
