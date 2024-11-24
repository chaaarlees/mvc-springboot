package com.charles.mvc_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charles.mvc_springboot.models.ParamsDto;
import com.charles.mvc_springboot.models.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableCotroller {

    // OBTENER VALORES DESDE EL APPLICATION.PROPERTIES
    @Value("${config.default-username}")
    private String defaultUsername;
    @Value("${config.default-age}")
    private Integer defaultUserAge;
    @Value("${config.default-lastname}")
    private String defaultUserLastName;
    @Value("${config.default-email}")
    private String defaultUserEmail;
    @Value("${config.default-wellcome-message}")
    private String defaultWellcomeMessage;
    @Value("${config.list.consolas}")
    private String[] consolesList;
    @Value("#{'${config.list.consolas}'.toLowerCase()}")
    private String consolesListMinus;
    @Value("#{${config.pc-specs}}")
    private Map<String,Object> pcSpecsList;

    private Environment enviroment; //OTRA FORMA DE ACCEDER A LAS PROPIEDADES

    //ENVIAR VALORES OBTENIDOS DESDE PROPERTIES
    @GetMapping("/default-values")
    public Map<String, Object> getDefaultValues() {
        Map<String, Object> json = new HashMap<>();
        json.put("default-username", defaultUsername);
        json.put("default-lastName", defaultUserLastName);
        json.put("default-email", defaultUserEmail);
        json.put("default-age", defaultUserAge);
        json.put("consoles-list", consolesList);
        json.put("default-wellcome",defaultWellcomeMessage);
        json.put("default-minus-list",consolesListMinus);
        json.put("default-specs-list", pcSpecsList);
        json.put("default-enviroment-property", enviroment.getProperty("config.enviroment-property"));
        

        return json;
    }

    @GetMapping("/fool/{message}")
    public ParamsDto fool(@PathVariable() String message) {
        ParamsDto params = new ParamsDto();
        params.setMessage(message);
        return params;
    }

    // http://localhost:8080/api/var/mix/mouse/221
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVariable(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    // Metodo POST para crear usuario
    // http://localhost:8080/api/var/create
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        user.setLastName(user.getLastName().toUpperCase());
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }

}
