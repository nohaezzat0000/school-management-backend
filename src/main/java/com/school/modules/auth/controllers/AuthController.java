package com.school.modules.auth.controllers;

import com.school.Dto.AuthResponseDTO;
import com.school.modules.user.dto.LoginDto;
import com.school.modules.auth.enums.Role;
import com.school.modules.user.dto.SignUpRequestDTO;
import com.school.modules.user.dto.UserResponseDTO;
import com.school.modules.auth.model.User;
import com.school.modules.user.mapper.UserMapper;
import com.school.modules.user.repository.UserRepository;
import com.school.modules.appCommon.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;
    private final UserMapper userMapper;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator,  UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.userMapper = userMapper;

    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtGenerator.generateToken(authentication);
            return ResponseEntity.ok(new AuthResponseDTO(token));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /*
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody SignUpRequestDTO dto){
        //Check if username already exists
        if(userRepository.findByUsername(dto.getUsername()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        //Create User
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRole(Role.USER); // force default role

        User saved = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(saved.getId());
        response.setUsername(saved.getUsername());
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());
        response.setEmail(saved.getEmail());
        response.setDateOfBirth(saved.getDateOfBirth());
        response.setPhoneNumber(saved.getPhoneNumber());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

     */

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody SignUpRequestDTO dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        // Map DTO to entity
        User user = userMapper.toEntity(dto);

        // Encode password manually because mapper can't encode it
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        // Force default role
        user.setRole(Role.USER);

        User saved = userRepository.save(user);
        // Map entity to response DTO
        UserResponseDTO response = userMapper.toDto(saved);

        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }



}
