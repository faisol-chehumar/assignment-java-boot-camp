package com.sol.demoecom.user;

import com.sol.demoecom.user.response.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserCredential login(String username, String password) {
        Optional<UserModel> matchedUser = userRepository.findByUsernameAndPassword(username, password);
        if(matchedUser.isPresent()) {
            return new UserCredential("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IlVzZXIwMSJ9.saNh8MedJAAeSWE06XH5M-2EcWny0ZFfvIS-qJjFfWk");
        }

        throw new AuthenticationFailException();
    }
}
