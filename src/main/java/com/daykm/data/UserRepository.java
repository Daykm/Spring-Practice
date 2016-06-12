package com.daykm.data;

import com.daykm.domain.SiteUser;

import java.util.List;

public interface UserRepository {

	SiteUser save(SiteUser user);

	SiteUser findByFirstName(String firstName);

	List<SiteUser> list();
}
