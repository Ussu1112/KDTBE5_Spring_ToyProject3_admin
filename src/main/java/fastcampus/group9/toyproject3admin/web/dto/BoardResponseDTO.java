package fastcampus.group9.toyproject3admin.web.dto;

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
    private LocalDateTime createdAt;

    public static BoardResponseDTO of(Board board){
        String isReported = "";
        if (board.isReported()){
            isReported = "신고";
        }
        return new BoardResponseDTO(
                board.getId(), board.getTitle(), board.getContent(), board.getAuthor(),
                isReported, board.getCreatedAt());
    }

    public static List<BoardResponseDTO> listOf(List<Board> board){
        return board.stream().map(BoardResponseDTO::of).collect(Collectors.toList());
    }
}


