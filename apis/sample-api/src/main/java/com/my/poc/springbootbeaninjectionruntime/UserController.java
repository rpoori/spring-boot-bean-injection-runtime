package com.my.poc.springbootbeaninjectionruntime;

import com.my.poc.user.GetActiveUsers;
import com.my.poc.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final GetActiveUsers getActiveUsers;

    @GetMapping("/active/{segment}")
    public ResponseEntity<List<User>> getActiveUsers(@PathVariable String segment,
                                                     HttpServletRequest httpServletRequest) {
        String profile = httpServletRequest.getHeader("profile");
        return ResponseEntity.ok(getActiveUsers.execute(segment, profile));
    }
}
