package com.patryk.booksrental.API.Assemblers;


import com.patryk.booksrental.API.Resources.UserResource;
import com.patryk.booksrental.Models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserResourceAssembler {

    public List<UserResource> buildResources(List<User> list){
        List<UserResource> userResources = list.stream().map(user-> {
            UserResource userResource = UserResource.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .last_name(user.getLast_name())
                    .email(user.getEmail())
                    .user_type(user.getUser_type())
                    .build();
            return userResource;
        }).collect(Collectors.toList());
        return userResources;
    }

    public UserResource buildResource(User user){
        UserResource userResource = UserResource.builder()
                .id(user.getId())
                .name(user.getName())
                .last_name(user.getLast_name())
                .email(user.getEmail())
                .user_type(user.getUser_type())
                .books(user.getBooks())
                .build();
        return userResource;
    }

}
