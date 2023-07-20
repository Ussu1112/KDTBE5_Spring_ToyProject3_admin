package fastcampus.group9.toyproject3admin.web.dto;

import fastcampus.group9.toyproject3admin.domain.user.User;
import fastcampus.group9.toyproject3admin.domain.user.UserRole;

import java.util.List;
import java.util.stream.Collectors;

public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private UserRole userRole;
    private boolean isBlacked;

    public UserResponse() {
    }

    public UserResponse(Long id, String username, String email, UserRole userRole, boolean isBlacked) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userRole = userRole;
        this.isBlacked = isBlacked;
    }

    public static UserResponse of(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.isBlacked());
    }

    public static List<UserResponse> listOf(List<User> user){
        return user.stream().map(UserResponse::of).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public boolean isBlacked() {
        return isBlacked;
    }
}
