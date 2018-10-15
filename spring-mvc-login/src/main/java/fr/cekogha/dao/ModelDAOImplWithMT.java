package fr.cekogha.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

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

	@Override
	public DeleteResult deleteModel(ObjectId modelId, Class<T> clazz) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("_id").is(modelId));		
		return mongoTemplate.remove(query,clazz);
	}

	@Override
	public void saveModel(T model) {
		// TODO Auto-generated method stub
		 mongoTemplate.save(model);
	}

	@Override
	public UpdateResult updateModel(Map<String, Object> changes, Map<String, Object> query, Class<T> clazz) {
		// TODO Auto-generated method stub
		Update updates = getChanges(changes);
		return  (UpdateResult) mongoTemplate.updateMulti(getCriterias(query), updates, clazz);
	}

	private Update getChanges(Map<String, Object> changes) {
		Update updates = new Update();
		for(Entry<String, Object> entry : changes.entrySet()) {
			updates.set(entry.getKey(), entry.getValue());
		}
		return updates;
	}
	
	private Query getCriterias(Map<String, Object> query) {
		Query q = new Query();
		for(Entry<String, Object> entry : query.entrySet()) {
			q.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
		}
		return q;
	}
	
}
