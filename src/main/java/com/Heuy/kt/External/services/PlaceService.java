package com.Heuy.kt.External.services;


import com.Heuy.kt.External.entities.Post;
import com.Heuy.kt.External.entities.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class PlaceService{
    StringBuilder baseUrl = new StringBuilder("https://jsonplaceholder.typicode.com");
    StringBuilder questionBaseUrl = new StringBuilder("https://opentdb.com/api.php");

    WebClient postClient = WebClient.create(baseUrl.toString());
    WebClient questionClient = WebClient.create(questionBaseUrl.toString());

    //
    public Mono<Post> getPost(){
        Mono<Post> result = postClient
                .get()
                .uri("/posts/50")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Post.class);
        return result;
    }

    public Flux<Question> getMultipleQuestions(String amount, String category){
        Flux<Question> result = questionClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("amount", amount)
                        .queryParam("category", category)
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Question.class);
        return result;
    }

//    Mono<Post> results = client
//            .get()
//            .uri("/posts")
//            .retrieve()
//            .bodyToMono(Post.class);

}
