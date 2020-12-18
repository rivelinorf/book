package io.cvortex.book.resouce.impl;

import io.cvortex.book.integration.AuthorFeign;
import io.cvortex.book.integration.AuthorFeignClient;
import io.cvortex.book.model.Book;
import io.cvortex.book.resouce.BookResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookResourceImpl implements BookResource {

    private final AuthorFeignClient client;

    @Override
    public Book findById(String id) {
        return Book.builder()
                .id(UUID.randomUUID().toString())
                .title("Book ABC")
                .author(client.findById(UUID.randomUUID().toString()))
                .build();
    }
}
