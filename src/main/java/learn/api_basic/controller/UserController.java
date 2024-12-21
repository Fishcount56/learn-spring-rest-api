package learn.api_basic.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import learn.api_basic.entity.UserEntity;
// import learn.api_basic.exception.ApiException;
import learn.api_basic.model.WebResponse;
import learn.api_basic.model.request.user.RegisterUserRequest;
import learn.api_basic.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(
        path = "/api/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Object> register(@RequestBody @Valid RegisterUserRequest request) {
        try {
            UserEntity registeredUser = userService.register(request);

            return WebResponse.builder()
                .status(HttpStatus.OK.value())
                .message("OK")
                .data(Map.of(
                    "users_id", registeredUser.getUsers_id(),
                    "username", registeredUser.getUsername()
                ))
                .errors(null)
                .build();
        } catch (Exception e) {
            return WebResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Internal Server Error")
                .data(null)
                .errors(Map.of(
                    "message", e.getMessage()
                ))
                .build();
        }
    }
}
