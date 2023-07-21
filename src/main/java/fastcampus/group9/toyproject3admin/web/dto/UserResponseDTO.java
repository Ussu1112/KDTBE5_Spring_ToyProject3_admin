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
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private UserRoleEnum userRole;
    private String isBlacked;

    public static UserResponseDTO of(User user){
        String isBlack = "블랙아님";
        if (user.isBlacked()){
            isBlack = "블랙";
        }
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), isBlack);
    }

    public static List<UserResponseDTO> listOf(List<User> user){
        return user.stream().map(UserResponseDTO::of).collect(Collectors.toList());
    }
}
