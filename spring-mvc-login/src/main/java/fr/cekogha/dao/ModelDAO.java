package fr.cekogha.dao;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public interface ModelDAO<T> {

	public T findModel(String username, Class<T> clazz);
	public T findModel(ObjectId modelId, Class<T> clazz);
	public List<T> findAllModel(Class<T> clazz);
	public DeleteResult deleteModel(ObjectId modelId, Class<T> clazz);
	public void saveModel(T model);
	public UpdateResult updateModel(Map<String, Object> changes, Map<String, Object> query, Class<T> clazz);
}
