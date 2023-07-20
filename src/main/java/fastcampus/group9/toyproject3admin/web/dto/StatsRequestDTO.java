package fastcampus.group9.toyproject3admin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StatsRequestDTO {
    private String columnName;
    private String order;
}
