package com.daykm;


import com.daykm.data.UserRepository;
import com.daykm.domain.SiteUser;
import com.daykm.web.MainController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class Tests {

	@Test
	public void testList() throws Exception {
		UserRepository repo = mock(UserRepository.class);

		List<SiteUser> users = getTestUsers(10);
		when(repo.findByFirstName("kody2")).thenReturn(users.get(2));
		when(repo.list()).thenReturn(users);

		MainController controller = new MainController(repo);

		MockMvc mvc = standaloneSetup(controller).build();

		mvc.perform(get("/testform/list")).andExpect(view().name("userList"));
	}


	private List<SiteUser> getTestUsers(int count) {
		ArrayList<SiteUser> users = new ArrayList<>(count);
		for(int i = 0; i < count; i++) {
			users.add(new SiteUser(
					"kody" + i,
					"day" + i,
					"password" + i,
					"daykm" + i + "@gmail.com"));
		}
		return users;
	}
}
