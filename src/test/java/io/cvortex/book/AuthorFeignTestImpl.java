package io.cvortex.book;

import io.cvortex.book.integration.AuthorFeign;
import io.cvortex.book.integration.AuthorFeignClient;
import io.cvortex.book.model.Author;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
public class AuthorFeignTestImpl implements AuthorFeignClient {

    @Override
    public Author findById(String id) {
        return Author.builder().id(BookApplicationTests.BOOK_ID).name(BookApplicationTests.BOOK_NAME).build();
    }

}
