package com.apurav.medialibrary.core.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.apurav.medialibrary.commons.dto.User;
import com.apurav.medialibrary.core.dao.IUserDao;

/**
 * 
 * @author apurav.chauhan
 *
 */
@Repository
public class UserDao implements IUserDao {
	@Autowired
	private MongoOperations mongoOps;

	public User add(User user) {
		mongoOps.save(user, "user");
		return user;
	}

	public User findByMail(String mail) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mail").is(mail));
		return mongoOps.findOne(query, User.class, "user");
	}

	@Override
	public void updatePref(String id,String mobile, Boolean privacy) {
		Query q = new Query(Criteria.where("_id").is(new ObjectId(id)));
		Update prefUpdate = new Update();
		prefUpdate.set("prvcy", privacy);
		prefUpdate.set("mob", mobile);
		mongoOps.updateFirst(q, prefUpdate,"user");
	}

	@Override
	public User findById(String id) {
		Query q = new Query(Criteria.where("_id").is(new ObjectId(id)));
		return mongoOps.findOne(q, User.class, "user");
	}
	
}
