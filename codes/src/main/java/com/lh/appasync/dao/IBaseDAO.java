package com.lh.appasync.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tju on 9/16/14.
 */
public interface IBaseDAO <T, PK extends Serializable>{
    /**
     * 保存实例进数据库
     * @param instance
     * @return
     */
    PK save(T instance);

    /**
     * 根据对象进行删除
     * @param model
     */
    void delete(T model);

    /**
     * 根据ID删除
     * @param id
     */
    void delete(PK id);

    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    T get(PK id);
    
    /**
     * 取得所有
     * @return
     */
    List<T> findAll();
    
	/**
	 * 更新对象
	 * 
	 * @param o
	 * @return
	 */
	public Object updateObject(Object o);
	
	/**
	 * @param hqlColumn
	 *        列头，以逗号隔开
	 * @param obj
	 *        实体Class
	 * @param str
	 *        二维组，String[][] str=new String[][]{{"name","=","value"}};
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Object> findparams(String hqlColumn, Object obj, String[][] str);
}
