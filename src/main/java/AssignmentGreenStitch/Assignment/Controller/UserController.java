package AssignmentGreenStitch.Assignment.Controller;

import AssignmentGreenStitch.Assignment.Dto.LoginDto;
import AssignmentGreenStitch.Assignment.Dto.Response;
import AssignmentGreenStitch.Assignment.Dto.UserRequestDto;
import AssignmentGreenStitch.Assignment.Model.User;
import AssignmentGreenStitch.Assignment.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<Response> signUp(@RequestBody @Valid UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.signUp(userRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(userService.login(loginDto));
    }
}
