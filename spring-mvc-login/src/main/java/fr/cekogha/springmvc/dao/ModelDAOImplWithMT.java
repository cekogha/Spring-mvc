package fr.cekogha.springmvc.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component("modelDAOImpl")
public class ModelDAOImplWithMT<T> implements ModelDAO<T> {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public T findModel(String username, Class<T> clazz) {
		// TODO Auto-generated method stub
		Query query = new  Query(Criteria.where("username").is(username));
		return (T) mongoTemplate.findOne(query, clazz);
	}

	@Override
	public T findModel(ObjectId modelId, Class<T> clazz) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("_id").is(modelId));
		return  (T) mongoTemplate.findById(query, clazz);
	}

	@Override
	public List<T> findAllModel(Class<T> clazz) {
		// TODO Auto-generated method stub
		return  (List<T>) mongoTemplate.findAll(clazz);
	}
	
}
