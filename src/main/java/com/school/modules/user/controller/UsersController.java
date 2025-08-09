package com.school.modules.user.controller;

import com.school.modules.user.dto.ContractDto;
import com.school.modules.user.dto.UserProfileDto;
import com.school.modules.user.model.Contract;
import com.school.modules.user.service.ContractService;
import com.school.modules.user.service.UserService;
import com.school.modules.appCommon.security.JWTGenerator;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UsersController {


    private final JWTGenerator jwtGenerator;
    private final UserService userService;
    private final ContractService contractService;

    public UsersController(JWTGenerator jwtGenerator, UserService userService, ContractService contractService) {
        this.jwtGenerator = jwtGenerator;
        this.userService = userService;
        this.contractService = contractService;
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
    @GetMapping("/test")
    public ResponseEntity<UserProfileDto> test(HttpServletRequest request) {

        ContractDto contract = new ContractDto();
        contract.setId(1L);
        contract.setStatus("Active");
        contract.setName("Example Contract");
        Contract ddddddd = contractService.convertToEntity(contract);
        return ResponseEntity.ok(null);
    }

}
