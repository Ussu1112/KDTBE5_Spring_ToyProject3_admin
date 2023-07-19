package fastcampus.group9.toyproject3admin.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class User {
    private Long Id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private UserRole role;
    private boolean isBlacked;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @Builder
    public User(Long id, String username, String password, String email, String nickname, UserRole role, boolean isBlacked, LocalDateTime createdAt, LocalDateTime updateAt) {
        Id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.isBlacked = isBlacked;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
