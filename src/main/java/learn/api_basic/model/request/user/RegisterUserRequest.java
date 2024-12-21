package learn.api_basic.model.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserRequest {
    @NotBlank(message = "username cannot be blank")
    @Size(max = 255, min = 6)
    private String username;

    @NotBlank(message = "password cannot be blank")
    @Size(max = 255, min = 6)
    private String password;
}
