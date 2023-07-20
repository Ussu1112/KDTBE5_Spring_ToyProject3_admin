package fastcampus.group9.toyproject3admin.web;

import fastcampus.group9.toyproject3admin.domain.email.EmailMessage;
import fastcampus.group9.toyproject3admin.domain.user.User;
import fastcampus.group9.toyproject3admin.service.email.EmailService;
import fastcampus.group9.toyproject3admin.service.user.UserService;
import fastcampus.group9.toyproject3admin.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fastcampus.group9.toyproject3admin.web.dto.UserRequest.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final EmailService emailService;

    @GetMapping("/api/v1/get/{username}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String username){
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(UserResponse.of(user));
    }

    @GetMapping("/api/v1/user")
    public ResponseEntity<List<UserResponse>> findAll(){
        List<User> userList = userService.findAll();
        return ResponseEntity.ok(UserResponse.listOf(userList));
    }

    @PutMapping("/api/v1/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateDTO updateDTO){
        userService.roleUpdate(updateDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/v1/black/{id}")
    public ResponseEntity<Void> userBlack(@PathVariable Long id){
        User user = userService.findById(id);

        EmailMessage emailMessage = EmailMessage.builder()
                .to(user.getEmail())
                .subject("당신 계정이 블랙되었습니다.")
                .build();

        emailService.sendMail(emailMessage, user.getUsername(), "userBlackEmailForm");
        return ResponseEntity.noContent().build();
    }
}
