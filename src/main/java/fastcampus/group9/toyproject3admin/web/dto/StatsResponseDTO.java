package fastcampus.group9.toyproject3admin.web.dto;

import fastcampus.group9.toyproject3admin.domain.stats.Stats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Builder
public class StatsResponseDTO {
    private String username;
    private String nickname;
    private Long userId;
    private int btCount;
    private int ctCount;

    public static StatsResponseDTO of(Stats stats){
        return new StatsResponseDTO(stats.getUsername(), stats.getNickname(), stats.getUserId(), stats.getBtCount(), stats.getCtCount());
    }

    public static List<StatsResponseDTO> listOf(List<Stats> stats){
        return stats.stream().map(StatsResponseDTO::of).collect(Collectors.toList());
    }
}
