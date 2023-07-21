package fastcampus.group9.toyproject3admin.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
public class StatsRequestDTO {
    private String columnName;
    private String order;

    @Builder
    public StatsRequestDTO(String columnName, String order) {
        this.columnName = columnName;
        this.order = order;
    }
}
