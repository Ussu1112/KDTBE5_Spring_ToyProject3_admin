package fastcampus.group9.toyproject3admin.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReportRequestDTO {
    private final Long boardId;
    private final String reportContent;

    @Builder
    public ReportRequestDTO(Long boardId, String reportContent) {
        this.boardId = boardId;
        this.reportContent = reportContent;
    }
}