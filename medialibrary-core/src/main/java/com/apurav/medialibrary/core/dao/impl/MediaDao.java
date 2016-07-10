package com.apurav.medialibrary.core.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.apurav.medialibrary.commons.dto.Media;
import com.apurav.medialibrary.commons.dto.Media.Type;
import com.apurav.medialibrary.core.dao.IMediaDao;

/**
 * 
 * @author apurav.chauhan
 *
 */
@Repository
public class MediaDao implements IMediaDao {
	@Autowired
	private MongoOperations mongoOps;

	/*public User add(User user) {
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
	}*/

	@Override
	public Media save(Media media) {
		mongoOps.save(media, "media");
		return media;
	}

	@Override
	public List<Media> search(String uid, Type type) {
		Query query = new Query(Criteria.where("crBy").is(uid));
		return mongoOps.find(query, Media.class,"media");
	}
	
	@Override
	public Media searchById(String uid, String mid) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(new ObjectId(mid)).and("crBy").is(uid));
		return mongoOps.findOne(query, Media.class, "media");
	}
	
}
