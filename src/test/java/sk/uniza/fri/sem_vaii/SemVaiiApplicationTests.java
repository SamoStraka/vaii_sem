package sk.uniza.fri.sem_vaii;
import static org.hamcrest.Matchers.hasSize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sk.uniza.fri.sem_vaii.aplication.dtos.AuthorDTO;
import sk.uniza.fri.sem_vaii.aplication.dtos.BookDTO;
import sk.uniza.fri.sem_vaii.aplication.dtos.ContactDTO;
import sk.uniza.fri.sem_vaii.domain.Language;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@EnableWebMvc
class SemVaiiApplicationTests {

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private MockMvc mvc;


	@Test
	void addAuthor() throws Exception {

		AuthorDTO newAuthor = new AuthorDTO();
		newAuthor.setId(6L);
		newAuthor.setName("Martin");
		newAuthor.setLastName("Nizky");
		newAuthor.setInfo("kratke nohy");

		mvc.perform(post("/api/author")
		.contentType(MediaType.APPLICATION_JSON)
		.content(toJson(newAuthor)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.id").value(6))
		.andExpect(jsonPath("$.name").value("Martin"))
		.andExpect(jsonPath("$.lastName").value("Nizky"))
		.andExpect(jsonPath("$.info").value("kratke nohy"));

		mvc.perform(delete("/api/author/6"));
	}

	@Test
	void updateAuthor() throws Exception {

		AuthorDTO newAuthor = new AuthorDTO();
		newAuthor.setId(6L);
		newAuthor.setName("Martin");
		newAuthor.setLastName("Nizky");
		newAuthor.setInfo("kratke nohy");

		mvc.perform(post("/api/author")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(newAuthor)))
				.andExpect(status().isCreated());

		newAuthor.setName("Dominik");
		newAuthor.setLastName("Vysoky");

		mvc.perform(put("/api/author/6")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(newAuthor)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(6))
				.andExpect(jsonPath("$.name").value("Dominik"))
				.andExpect(jsonPath("$.lastName").value("Vysoky"));

		mvc.perform(delete("/api/author/6"));
	}

	@Test
	void sortingContactsTest() throws Exception {

		ContactDTO contactDTOSolved = new ContactDTO();
		contactDTOSolved.setId(100L);
		contactDTOSolved.setName("meno1");
		contactDTOSolved.setEmail("email");
		contactDTOSolved.setSubject("subject");
		contactDTOSolved.setMessage("message");
		contactDTOSolved.setSolved(true);

		mvc.perform(post("/api/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(contactDTOSolved)));

		ContactDTO contactDTOUnsolved = new ContactDTO();
		contactDTOUnsolved.setId(101L);
		contactDTOUnsolved.setName("meno2");
		contactDTOUnsolved.setEmail("email");
		contactDTOUnsolved.setSubject("subject");
		contactDTOUnsolved.setMessage("message");
		contactDTOUnsolved.setSolved(false);

		mvc.perform(post("/api/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(contactDTOUnsolved)));

		mvc.perform(get("/api/contact"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id").value(101))
				.andExpect(jsonPath("$[0].name").value("meno2"))
				.andExpect(jsonPath("$[1].id").value(100))
				.andExpect(jsonPath("$[1].name").value("meno1"));

		mvc.perform(delete("/api/contact/100"));
		mvc.perform(delete("/api/contact/101"));
	}

	@Test
	void testBookByTitle() throws Exception {

		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(100L);
		bookDTO.setAvailable(1L);
		bookDTO.setBookGenres(Collections.emptySet());
		bookDTO.setTitle("Kniha");
		bookDTO.setInfo("info");
		bookDTO.setAuthors(Collections.emptySet());
		bookDTO.setNumberOfPages(10L);
		var language = new Language();
		language.setId(1L);
		language.setName("SVK");
		bookDTO.setLanguage(language);
		bookDTO.setReleaseYear(2020L);
		bookDTO.setIsbn("isbn-je-tu");

		mvc.perform(post("/api/book")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(bookDTO)));

		mvc.perform(get("/api/book?title=Kniha"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id").value(100))
				.andExpect(jsonPath("$[0].title").value("Kniha"));

		bookDTO.setTitle("KnihaNew");

		mvc.perform(put("/api/book/100")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(bookDTO)));

		mvc.perform(get("/api/book?title=KnihaNew"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id").value(100))
				.andExpect(jsonPath("$[0].title").value("KnihaNew"));

		mvc.perform(delete("/api/book/100"));
	}



	private String toJson(AuthorDTO authorDTO) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(authorDTO);
	}

	private String toJson(ContactDTO contactDTO) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(contactDTO);
	}

	private String toJson(BookDTO bookDTO) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(bookDTO);
	}

}
