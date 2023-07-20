package fastcampus.group9.toyproject3admin.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class Board {

    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String author;
    private boolean isReported;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @Builder
    public Board(Long id, Long userId, String title, String content, String author, boolean isReported, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.isReported = isReported;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
