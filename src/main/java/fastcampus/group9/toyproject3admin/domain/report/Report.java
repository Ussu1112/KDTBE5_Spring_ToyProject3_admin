package fastcampus.group9.toyproject3admin.domain.report;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Report {
    private Long id;
    private Long boardId;
    private boolean isReported;
    private String reportContent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Report(Long id, Long boardId, boolean isReported, String reportContent, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.boardId = boardId;
        this.isReported = isReported;
        this.reportContent = reportContent;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
