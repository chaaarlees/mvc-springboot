package com.charles.mvc_springboot.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.charles.mvc_springboot.models.User;
import com.charles.mvc_springboot.models.dto.UserDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;




@RestController //indica que es un controlador rest
@RequestMapping("/api") //le da una ruta por defecto a nuestro controlador
public class UserRestController {

    // OBTENER USUARIO CON MAP    
    // @RequestMapping(path="/users", method=RequestMethod.GET) equivalente
    @GetMapping("/users-map")
    public Map <String,Object> users() {
        Map <String,Object> body = new HashMap<>();
        User user = new User("Charles","Thenoux","charles_dev@email.com");
        body.put("title", "HOLA MUNDO JAVA MVC SPRINGBOOT");
        body.put("user", user);
        return body;

    }

    //OBTENER USUARIO CON DTO
    @GetMapping("/users-dto")
    public Map <String,Object> usersDto(){
        Map<String,Object> body = new HashMap<>();
        User user = new User("Charles", "Thenoux", "charles_dev@gmail.com" );
        UserDto userDto = new UserDto();
        userDto.setTitle("HOLA MUNDO JAVA MVC SPRINGBOOT");
        userDto.setFullName(user.getName().concat(" ").concat(user.getLastName()));
        userDto.setWellcomeMessage("Bienvenido ".concat(userDto.getFullName()));

        userDto.setUser(user);
        body.put("userDto   ", userDto);
        body.put("title", userDto.getTitle());
        return body;
    }

    //OBTENER LISTA DE USUARIOS
    @GetMapping("/users-list")
    public List<User> list(){
        User user1 = new User("Jhon","Wick","jw@email.com"); 
        User user2 = new User("Micke","Wasousky","mw@email.com"); 
        User user3 = new User("Optimus","Prime","op@email.com"); 
        
        // List<User> users = new ArrayList<>();
        // users.add(user1);
        // users.add(user2);
        // users.add(user3);

        // de forma más eficiente usando un helper ↓
        List<User> users = Arrays.asList(user1,user2,user3);

        return users;
    }

}   
