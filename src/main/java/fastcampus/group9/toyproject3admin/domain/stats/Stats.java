package fastcampus.group9.toyproject3admin.domain.stats;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Stats {
    private String username;
    private String nickname;
    private Long userId;
    private int btCount;
    private int ctCount;

    @Builder
    public Stats(String username, String nickname, Long userId, int btCount, int ctCount) {
        this.username = username;
        this.nickname = nickname;
        this.userId = userId;
        this.btCount = btCount;
        this.ctCount = ctCount;
    }
}
