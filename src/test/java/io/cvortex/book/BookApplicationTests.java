package io.cvortex.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cvortex.book.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class BookApplicationTests {

	private static final String URL = "/books/";
	public static final String BOOK_ID = "f376f469-e474-4cdd-a7f5-3d55491377a2";
	public static final String BOOK_NAME = "MOCK DA SILVA SOUZA";

	@Autowired
	protected MockMvc mvc;

	@Autowired protected ObjectMapper mapper;

	@Test
	public void should_get_books() throws Exception {
		MockHttpServletRequestBuilder builder =
				get(URL.concat("/").concat(BOOK_ID)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		ResultActions resultActions = this.mvc.perform(builder);

		Book book = mapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Book.class);
		assertNotNull(book);
		assertNotNull(book.getAuthor());
		assertEquals(BOOK_ID, book.getAuthor().getId());
		assertEquals(BOOK_NAME, book.getAuthor().getName());
	}

}
