package com.younger.security.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create on 2022/03/14. create by IntelliJ IDEA.
 *
 * <p> 사진 갤러리 게시판 CRUD 컨트롤러 </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/v1/gallery")
@RequiredArgsConstructor
public class GalleryApi {
  @GetMapping
  public ResponseEntity<String> getList() {

    return new ResponseEntity<>("gallery list", HttpStatus.OK);
  }
}
