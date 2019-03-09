package com.learning.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.entites.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate template;
	private static final String save_query = "insert into UserMaster(name,mailId,password)values(?,?,?)";

	public void save(User user) throws Exception {
		template.update(save_query, user.getName(), user.getMailId(), user.getPassword());
	}

}
