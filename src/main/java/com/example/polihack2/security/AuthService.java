package com.example.polihack2.security;

import com.example.polihack2.mapper.ClientMapper;
import com.example.polihack2.model.Client;
import com.example.polihack2.model.Role;
import com.example.polihack2.model.ERole;
import com.example.polihack2.model.User;
import com.example.polihack2.repos.ClientRepo;
import com.example.polihack2.security.dto.SignupRequest;
import com.example.polihack2.user.RoleRepository;
import com.example.polihack2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder encoder;
  private final ClientRepo clientRepo;

  public boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }


  public void register(SignupRequest signUpRequest) {
    User user = User.builder()
        .username(signUpRequest.getUsername())
        .password(encoder.encode(signUpRequest.getPassword()))
        .build();

    Set<String> rolesStr = signUpRequest.getRoles();
    Set<Role> roles = new HashSet<>();

    if (rolesStr == null) {
      Role defaultRole = roleRepository.findByName(ERole.CLIENT)
          .orElseThrow(() -> new RuntimeException("Cannot find CLIENT role"));
      roles.add(defaultRole);
    } else {
      rolesStr.forEach(r -> {
        Role ro = roleRepository.findByName(ERole.valueOf(r))
            .orElseThrow(() -> new RuntimeException("Cannot find role: " + r));
        roles.add(ro);
      });
    }

    //answerRepo.save(answerMapper.dtoToEntity(answer));

//    if(roles.contains("CLIENT")){
      Client client = Client.builder()
              .user(user)
              .build();
      clientRepo.save(client);
//    }

    user.setRoles(roles);
    userRepository.save(user);
  }
}