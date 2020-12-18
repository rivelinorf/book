package io.cvortex.book.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;

//@Profile("test")
public interface AuthorFeignTest extends AuthorFeign {
}
