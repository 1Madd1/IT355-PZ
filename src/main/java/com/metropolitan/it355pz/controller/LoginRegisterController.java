package com.metropolitan.it355pz.controller;

import com.metropolitan.it355pz.entity.User;
import com.metropolitan.it355pz.dto.UserLoginDTO;
import com.metropolitan.it355pz.dto.UserRegisterDTO;
import com.metropolitan.it355pz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login_register")
@RequiredArgsConstructor
public class LoginRegisterController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterDTO userRegisterRequest) {
        if(userService.findByEmail(userRegisterRequest.getEmail()) != null){
            return ResponseEntity.badRequest().body("Error: Email is already taken!");
        }
        User user = new User();
        user.setEnabled(true);
        user.setRole("ROLE_USER");
        user.setUsername(userRegisterRequest.getUsername());
        user.setEmail(userRegisterRequest.getEmail());
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        User savedUser = userService.save(user);
        System.out.println(savedUser);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginRequest) {
        System.out.println(userLoginRequest);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequest.getUsername(), userLoginRequest.getPassword()));
        System.out.println("aaaaaaaaaaaa");
        SecurityContextHolder.getContext().setAuthentication(authentication);

//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
        return ResponseEntity.ok(userService.findByUsername(userLoginRequest.getUsername()));
//        System.out.println(new UserInfoResponse(userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles));
//        return ResponseEntity.ok()
//                .body(new UserInfoResponse(userDetails.getId(),
//                        userDetails.getUsername(),
//                        userDetails.getEmail(),
//                        roles));
    }

}
