package io.haedoang.apiserver.api.board.ui;

import io.haedoang.apiserver.board.domain.Board;
import io.haedoang.apiserver.user.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * author : haedoang
 * date : 2022/03/13
 * description :
 */
@RestController
@RequestMapping("${api.appVer}/boards")
public class BoardRestController {
    private final AtomicLong count = new AtomicLong();

    @GetMapping
    public ResponseEntity<List<Board>> boards() {
        final List<Board> boards = Arrays.asList(
                Board.valueOf(null, "안녕하세요", "테스트입니다."),
                Board.valueOf(null, "안녕하세요2", "테스트입니다2."),
                Board.valueOf(null, "안녕하세요3", "테스트입니다3."),
                Board.valueOf(null, "안녕하세요4", "테스트입니다4."),
                Board.valueOf(null, "안녕하세요5", "테스트입니다5.")
        );

        return ResponseEntity.ok().body(boards);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_PREMIUM')")
    public ResponseEntity<Board> addBoard(@RequestBody Board board) {
        return ResponseEntity.created(URI.create("/boards/" + count.incrementAndGet())).body(board);
    }
}
