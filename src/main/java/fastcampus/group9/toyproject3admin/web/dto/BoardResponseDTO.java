package fastcampus.group9.toyproject3admin.web.dto;

import fastcampus.group9.toyproject3admin._core.utils.DateUtils;
import fastcampus.group9.toyproject3admin.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String isReported;
    private String reportFlag;
    private String createdAt;

    public static BoardResponseDTO of(Board board){
        String isReported = "보이기";
        if (board.isReported()){
            isReported = "숨김";
        }

        String reportFlag = "";
        if (board.isReportFlag())
            reportFlag = "신고된 게시글";

        return new BoardResponseDTO(
            board.getId(), board.getTitle(), board.getContent(), board.getAuthor(),
            isReported, reportFlag, DateUtils.toStringFormat(board.getCreatedAt()));
    }

    public static List<BoardResponseDTO> listOf(List<Board> board){
        return board.stream().map(BoardResponseDTO::of).collect(Collectors.toList());
    }
}


