package org.factoriaf5.backend;

import org.factoriaf5.backend.persistence.MovieRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {

	@Autowired
	private MockMvc api;

	@Autowired
	private MovieRepository repository;

	@BeforeEach
	void setup() {
		repository.deleteAll();
	}

	@Test
	void returnsListOfMovies() throws Exception{

		api.perform(get("/movies"))
		.andExpectAll(
			status().isOk(),
			jsonPath("$[0].title", equalTo("Socorro")));
	}

}
