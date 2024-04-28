package G1TBD.LABTBD.auth.services;

import G1TBD.LABTBD.auth.entities.AuthResponse;
import G1TBD.LABTBD.auth.entities.LoginRequest;
import G1TBD.LABTBD.auth.entities.RegisterRequest;
import G1TBD.LABTBD.config.JwtService;
import G1TBD.LABTBD.entities.UserEntity;
import G1TBD.LABTBD.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = UserEntity.builder()
                .rut(request.getRut())
                .email(request.getEmail())
                .name(request.getName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .sex(request.getSex())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .availability(request.isAvailability())
                .build();
        userRepository.create(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getRut(), request.getPassword())
        );

        var user = userRepository.getByRut(request.getRut()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

}
