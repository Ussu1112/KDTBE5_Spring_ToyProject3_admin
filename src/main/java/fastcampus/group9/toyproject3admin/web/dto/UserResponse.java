package fastcampus.group9.toyproject3admin.web.dto;

import fastcampus.group9.toyproject3admin.domain.user.User;
import fastcampus.group9.toyproject3admin.domain.user.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private UserRoleEnum userRole;
    private boolean isBlacked;

    public static UserResponse of(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.isBlacked());
    }

    public static List<UserResponse> listOf(List<User> user){
        return user.stream().map(UserResponse::of).collect(Collectors.toList());
    }
}
