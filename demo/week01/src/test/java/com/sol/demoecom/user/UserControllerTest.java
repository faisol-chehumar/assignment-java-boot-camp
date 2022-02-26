package com.sol.demoecom.user;

import com.sol.demoecom.common.ResponseSuccess;
import com.sol.demoecom.user.response.UserCredential;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    UserRepository userRepository;

    @Test
    @DisplayName("Should return credential when login with username: 'user01' and password: 'pass'")
    void login_withCorrectUserAndPass_tokenIsNotEmpty() throws JSONException {
        // Arrange
        String testUsername = "user01";
        String testPassword = "pass";
        UserModel user = new UserModel(testUsername, testPassword);

        when(userRepository.findByUsernameAndPassword(testUsername, testPassword)).thenReturn(Optional.of(user));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject loginJsonObject = new JSONObject();
        loginJsonObject.put("username", testUsername);
        loginJsonObject.put("password", testPassword);
        HttpEntity<String> request =
                new HttpEntity<String>(loginJsonObject.toString(), headers);

        // Action
        String stringResponse = testRestTemplate.postForObject("/user/login", request, String.class);
        JSONObject jsonResponse = new JSONObject(stringResponse);

        String token = jsonResponse.getJSONObject("data").getString("token");

        // Assert
        assertThat(token).isNotEmpty();

    }
}