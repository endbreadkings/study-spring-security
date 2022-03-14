package io.haedoang.apiserver.board.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * author : haedoang
 * date : 2022/03/13
 * description :
 */
@Entity
@Table(name = "boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long upBoardId;

    private String title;

    private String context;

    private Board(Long upBoardId, String title, String context) {
        this.upBoardId = upBoardId;
        this.title = title;
        this.context = context;
    }

    public static Board valueOf(Long upBoardId, String title, String context) {
        return new Board(upBoardId, title, context);
    }

    public Long getUpBoardId() {
        return upBoardId;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }
}
