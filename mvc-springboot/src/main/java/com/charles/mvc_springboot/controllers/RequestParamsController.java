package com.charles.mvc_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charles.mvc_springboot.models.ParamsDto;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/params")
// CONTROLADOR REST PARA PASAR PARAMETROS DEL USUARIO MEDIANTE LA URL
public class RequestParamsController {
    
    // http://localhost:8080/api/params/foo?message=mensaje
    @GetMapping("/foo")
    public ParamsDto foo(@RequestParam(required = false) String message) {
        ParamsDto param = new ParamsDto();
        param.setMessage(
            message != null ? message : "Favor agregue un mensaje en la url usando la notación: ?message=mensaje");
            return param;
    }

    // http://localhost:8080/api/params/bar?rut=12345&edad=21&mensaje=mensaje
    @GetMapping("/bar")
    public ParamsDto bar(
        @RequestParam(required = false, name = "mensaje") String message,
        @RequestParam(required = false, name = "edad") Integer age,
        @RequestParam() String rut) 
    {
        ParamsDto params = new ParamsDto();
        params.setMessage(message != null ? message : "Sin Mensaje");
        params.setEdad(age != null ? age : 0);
        params.setRut(rut);
        return params;
    }

    // Obtener datos del Request de forma nativa con HttpServletRequest
    // http://localhost:8080/api/params/servletRequest?rut=12345&edad=21&message=mensaje%20de%20prueba
    @GetMapping("/servletRequest")
    public ParamsDto request(HttpServletRequest request) {
        ParamsDto params = new ParamsDto();
        params.setMessage(request.getParameter("message"));
        params.setRut(request.getParameter("rut"));
        params.setEdad(Integer.parseInt(request.getParameter("edad")));
        return params;
    }

    
    

}
