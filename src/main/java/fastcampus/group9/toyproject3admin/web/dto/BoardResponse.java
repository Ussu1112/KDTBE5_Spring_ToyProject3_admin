package fastcampus.group9.toyproject3admin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private boolean reportFlag;
    private boolean isReported;
    private LocalDateTime createdAt;
}
