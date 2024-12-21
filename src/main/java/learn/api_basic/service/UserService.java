package learn.api_basic.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import learn.api_basic.entity.UserEntity;
import learn.api_basic.exception.ApiException;
import learn.api_basic.model.request.user.RegisterUserRequest;
import learn.api_basic.repository.user.UserRepository;
import learn.api_basic.security.BCrypt;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public UserEntity register(RegisterUserRequest request) {
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(request);

        if (constraintViolations.size() != 0) {
            throw new ConstraintViolationException(constraintViolations);
        }

        if (userRepository.findByusername(request.getUsername()).isPresent()) {
            throw new ApiException("Username Already Taken!");
        }


        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));

        return userRepository.save(userEntity);
    }
}
