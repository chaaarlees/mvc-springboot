package com.charles.mvc_springboot.controllers;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.charles.mvc_springboot.models.User;



@Controller//Anotacion para indicar que es un controlador
public class UserController {

    //PASAR DATOS A LA VISTA USANDO MAP
    // @GetMapping("/")
    // public String index(Map<String, Object> model) {
    //     model.put("title", "HOLA MUNDO JAVA MVC SPRINGBOOT CON MAP");
    //     model.put("name", "Charles");
    //     model.put("lastname", "Thenoux");
    //     model.put("wellcomeMessage", "Bienvenido al curso de SpringBoot");
    //     return "index";
    // }
    

    // PASAR DATOS A LA VISTA USANDO MODEL
    @GetMapping("/") //anotación para mapear HTTP GET request
    public String index( Model model) {
        User user = new User("Charles", "Thenoux", "charles_dev@example.com");
        model.addAttribute("title", "HOLA MUNDO JAVA MVC SPRINGBOOT");
        model.addAttribute("wellcomeMessage", "Bienvenido al curso de SpringBoot");
        model.addAttribute("user", user);
        return "index";
    }

    //PASAR LISTA A LA VISTA DIRECTAMENTE
    // @GetMapping("/list")
    // public String list(ModelMap model) {
    //     User user = new User("Charles","Thenoux","ctr@gmail.com");
    //     User user2 = new User("Jhon","Wick");
    //     User user3 = new User("Ash","Ketchup","ak@gmail.com");
    //     List<User> users = Arrays.asList(user,user2,user3);
    //     model.addAttribute("users", users);
    //     model.addAttribute("title", "Listado de usuarios");
    //     model.addAttribute("wellcomeMessage", "Bienvenido al curso de SpringBoot");

    //     return "list";
    // }

    // AGREGAR LISTA DE USUARIOS COMO MODEL ATRIBUTTE
    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(
            new User("Charles","Thenoux","ctr@gmail.com"),
            new User("Jhon","Wick"),
            new User("Ash","Ketchup","ak@gmail.com"),
            new User("Ken", "Katsuragui")
        );
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "listado de usuarios");
        return "list";
    }
        

}
