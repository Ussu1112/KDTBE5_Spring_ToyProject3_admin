package fastcampus.group9.toyproject3admin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class StatsResponseDTO {
    private String username;
    private String nickname;
    private Long user_id;
    private int bt_count;
    private int ct_count;

}
