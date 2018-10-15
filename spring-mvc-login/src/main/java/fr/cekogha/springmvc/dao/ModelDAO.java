package fr.cekogha.springmvc.dao;

import java.util.List;

import org.bson.types.ObjectId;

public interface ModelDAO<T> {

	public T findModel(String username, Class<T> clazz);
	public T findModel(ObjectId modelId, Class<T> clazz);
	public List<T> findAllModel(Class<T> clazz);
}
