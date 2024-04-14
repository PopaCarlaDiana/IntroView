package com.example.polihack2.security;

import com.example.polihack2.security.dto.*;
import com.example.polihack2.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

import static com.example.polihack2.UrlMapping.*;

@RequestMapping(AUTH)
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final AuthService authService;
  private final JwtUtils jwtUtils;

  @PostMapping(SIGN_IN)
  public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());

    return ResponseEntity.ok(
        JwtResponse.builder()
            .token(jwt)
            .id(userDetails.getId())
            .username(userDetails.getUsername())
            .roles(roles)
            .build());
  }

  @PostMapping(SIGN_UP)
  public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
    if (authService.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    authService.register(signUpRequest);


    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

}