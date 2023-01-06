package sk.uniza.fri.sem_vaii;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import sk.uniza.fri.sem_vaii.aplication.controllers.AuthorController;

@SpringBootTest
class SemVaiiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AuthorController authorController;

	@Test
	void contextLoads() {

	}

}
