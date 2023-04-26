package com.chatgpt.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class MatrixController {

    @PostMapping("matrix/sumMainDiagonal")
    public Mono<Integer> sumMainDiagonal(@RequestBody Integer[][] matrix) {
        return Flux.fromArray(matrix)
                .flatMap(Flux::fromArray)
                .index()
                .filter(t -> t.getT1().equals(t.getT2()))
                .map(Tuple2::getT2)
                .reduce(Integer::sum);
    }
}
