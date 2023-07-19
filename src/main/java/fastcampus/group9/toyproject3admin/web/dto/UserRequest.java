package fastcampus.group9.toyproject3admin.web.dto;

import fastcampus.group9.toyproject3admin.domain.user.UserRole;
import lombok.Getter;
import lombok.Setter;

public class UserRequest {

    @Getter @Setter
    public static class UpdateDTO {
        private Long id;
        private String userRole;

        public UpdateDTO(Long id, UserRole userRole) {
            this.id = id;
            this.userRole = userRole.getName();
        }
    }
}
