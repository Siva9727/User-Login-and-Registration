package AssignmentGreenStitch.Assignment.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "first name shouldn't be null or blank")
    private String firstName;
    @NotBlank(message = "last name shouldn't be null or blank")
    private String lastName;
    @Email
    private String email;

    @NotBlank(message = "provide password")
    private String password;
}
