package AssignmentGreenStitch.Assignment.Service;

import AssignmentGreenStitch.Assignment.Dto.LoginDto;
import AssignmentGreenStitch.Assignment.Dto.Response;
import AssignmentGreenStitch.Assignment.Dto.UserRequestDto;
import AssignmentGreenStitch.Assignment.Model.Role;
import AssignmentGreenStitch.Assignment.Model.User;
import AssignmentGreenStitch.Assignment.Repository.UserRepository;
import AssignmentGreenStitch.Assignment.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Response signUp(UserRequestDto userRequestDto){
        var userEntity = User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(userEntity);
        var jwtToken = jwtService.generateToken(userEntity);
        return Response.builder()
                .token(jwtToken)
                .build();
    }



    public Response login(LoginDto loginDto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        User user;
        try {
            user = userRepository.findByEmail(loginDto.getEmail());
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
        var jwtToken = jwtService.generateToken(user);
        return Response.builder()
                .token(jwtToken)
                .build();
    }
}
