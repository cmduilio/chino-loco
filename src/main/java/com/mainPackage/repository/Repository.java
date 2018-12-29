package com.mainPackage.repository;

import java.util.List;

//Interface for all daos
public interface Repository<T> {

	public void add(T t);
	public void update(T t);
	public List<T> getList(Class<T> zClass);
	public T getById(int id, Class<T> zClass);
	public void remove(int id, Class<T> zClass);
}
