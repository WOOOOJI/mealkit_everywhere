package com.admin.frame;

import java.util.List;

public interface MyService<K, V> {
	public void register(V v) throws Exception;
	public void remove(K k) throws Exception;
	public void modify(V v) throws Exception;

	public V get(K k) throws Exception;
	public List<V> get() throws Exception;
}
