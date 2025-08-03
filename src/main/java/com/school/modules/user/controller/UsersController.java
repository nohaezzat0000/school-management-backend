package com.school.modules.user.controller;

import com.school.modules.auth.model.User;
import com.school.modules.user.dto.UserProfileDto;
import com.school.modules.user.service.UserService;
import com.school.security.JWTGenerator;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UsersController {


    private final JWTGenerator jwtGenerator;
    private final UserService userService;

    public UsersController(JWTGenerator jwtGenerator, UserService userService) {
        this.jwtGenerator = jwtGenerator;
        this.userService = userService;
    }

    @GetMapping("/Profile")
    public ResponseEntity<UserProfileDto> userProfile(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = header.substring(7);
        Claims claims = jwtGenerator.getAllClaimsFromToken(token);
        Long userId = Long.valueOf(claims.get("userId").toString());

        UserProfileDto profile = userService.getUserProfileById(userId);
        return ResponseEntity.ok(profile);
    }

}
