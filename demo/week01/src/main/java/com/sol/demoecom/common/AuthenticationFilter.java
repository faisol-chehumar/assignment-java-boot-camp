package com.sol.demoecom.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sol.demoecom.user.model.UserModel;
import com.sol.demoecom.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    private static String SHOULD_NOT_FILTER = "not-filter";

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = request.getHeader("token");
            List<String> urls = new ArrayList<>();
            urls.add("/user");

            if(stringContainsItemFromList(request.getRequestURI(), urls).size() > 0 && !request.getRequestURI().equals("/user/login")) {
                if(token == null) {
                    throw new UnauthorizationException();
                }

                UUID userId = UUID.fromString(token);
                Optional<UserModel> user = userRepository.findById(userId);

                if(!user.isPresent()) {
                    throw new UnauthorizationException();
                }
            }


            filterChain.doFilter(request, response);

        } catch (RuntimeException e) {
            ResponseFail responseFail = new ResponseFail(e.getMessage());

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(convertObjectToJson(responseFail));
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return Boolean.TRUE.equals(request.getAttribute(SHOULD_NOT_FILTER));
    }

    private List<String> stringContainsItemFromList(String search, List<String> list) {
        List<String> matchingElements = list.stream()
                .filter(str -> search.trim().contains(str))
                .collect(Collectors.toList());
        return matchingElements;
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
