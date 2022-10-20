package com.example.spacexnote.controller;


import com.example.spacexnote.security.UserDetailsImpl;
import com.example.spacexnote.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    @GetMapping("/api/posts/{id}/like")
    public void ClickLike(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ControllerFuction.membercheck(userDetails);
        likeService.ClickLike(id,userDetails);
    }
}
