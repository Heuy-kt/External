package com.Heuy.kt.External.controllers;

import com.Heuy.kt.External.entities.Post;
import com.Heuy.kt.External.entities.Question;
import com.Heuy.kt.External.services.PlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("heklo")
public record PlaceController(PlaceService placeService) {

    @GetMapping("/get1")
    public String getCall(){
        Post post = placeService.getPost().block();
        String titleInEnglish = post.getTitle()+" is not in English and the Body is \n\n"+post.getBody();
        return titleInEnglish;
    }
//
//    @GetMapping("/get_more")
//    public Flux<Question> getMoreCalls(@RequestParam("amount") String amount, @RequestParam("category") String category){
//        return placeService.getMultipleQuestions(amount, category);
//    }
}
