package io.cvortex.book.resouce;

import io.cvortex.book.model.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public interface BookResource {

    @GetMapping("/{id}")
    Book findById(@PathVariable("id") final String id);
}
