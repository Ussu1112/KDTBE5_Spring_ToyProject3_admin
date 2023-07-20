package fastcampus.group9.toyproject3admin.web.dto;

import fastcampus.group9.toyproject3admin.domain.user.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

public class UserRequest {

    @Getter @Setter
    public static class UpdateDTO {
        private Long id;
        private String userRole;

        public UpdateDTO(Long id, UserRoleEnum userRole) {
            this.id = id;
            this.userRole = String.valueOf(userRole);
        }
    }
}
