package io.cvortex.book.integration;

import io.cvortex.book.model.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Profile("!test")
@FeignClient(
        url = "${author-api.url}",
        name = "author-api")
public interface AuthorFeignClient {

    @GetMapping("/{id}")
    Author findById(@PathVariable("id") final String id);
}
