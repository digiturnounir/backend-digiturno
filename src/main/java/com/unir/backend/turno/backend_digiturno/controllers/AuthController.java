package com.unir.backend.turno.backend_digiturno.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.backend.turno.backend_digiturno.Services.UserService;
import com.unir.backend.turno.backend_digiturno.dto.LoginRequest;
import com.unir.backend.turno.backend_digiturno.jwt.JwtUtil;
import com.unir.backend.turno.backend_digiturno.models.entities.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        System.out.println("Correo recibido: " + request.getCorreo());
        System.out.println("Contraseña recibida: " + request.getContrasena());
        Optional<User> userOptional = userService.findByCorreo(request.getCorreo());

        if (userOptional.isPresent() && userOptional.get().getContrasena().equals(request.getContrasena())) {
            String token = jwtUtil.generateToken(request.getCorreo());
            return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
