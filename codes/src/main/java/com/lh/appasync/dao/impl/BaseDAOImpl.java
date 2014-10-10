package com.lh.appasync.dao.impl;

import com.lh.appasync.dao.IBaseDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by tju on 9/16/14.
 */

public abstract class BaseDAOImpl<T, PK extends Serializable> implements IBaseDAO<T, PK> {

    @Autowired
    public SessionFactory sfMyStyleMaster;

    @Autowired
    public SessionFactory sfTestMaster;

    /**Log4j*/
    private static final Logger _logger = LoggerFactory.getLogger(BaseDAOImpl.class);

    /**泛型传入的类*/
    private final Class<T> entityClass;

    public BaseDAOImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types =genericSuperclass.getActualTypeArguments();
        this.entityClass = (Class<T>)  types[0];
        _logger.debug("Entity Class Name: {}", this.entityClass.getName());
    }

    @Transactional("tmMyStyleMaster")
    public PK save(T model) {
        return (PK) getMyStyleMasterSession().save(model);
    }

    @Transactional("tmMyStyleMaster")
    public void delete(T model) {
        getMyStyleMasterSession().delete(model);
    }

    @Transactional("tmTestMaster")
    public T get(PK id) {
        T result =  (T) getTestMasterSession().get(this.entityClass, id);

        return result;
    }

    @Transactional("tmMyStyleMaster")
    public void  delete(PK id) {
        T instance = get(id);
        if(instance ==null){
            _logger.debug("instance not found: {}, {}", entityClass.getName(), id);
        } else {
            delete(instance);
        }
    }
    
    @Transactional("tmTestMaster")
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
    	String hql = "from " + getObjectString(this.entityClass.getName());
		return getTestMasterSession().createQuery(hql).list();
    }
    
    @Transactional("tmMyStyleMaster")
    @Override
    public Object updateObject(Object o) {
    	Object obj = getMyStyleMasterSession().merge(o);
		return obj;
    }


    public Session getMyStyleMasterSession() {
        Session session =  sfMyStyleMaster.getCurrentSession();
        return session;
    }

    public Session getTestMasterSession() {
        Session session =  sfTestMaster.getCurrentSession();
        return session;
    }

    public void setSfMyStyleMaster(SessionFactory sfMyStyleMaster) {
        this.sfMyStyleMaster = sfMyStyleMaster;
    }

    public void setSfTestMaster(SessionFactory sfTestMaster) {
        this.sfTestMaster = sfTestMaster;
    }
    
	/**
	 * query 参数赋值
	 * 
	 * @param query
	 *        query对象
	 * @param param
	 *        参数值
	 */
	public void initQueryParam(Query query, Object param) {
		if (query == null || param == null) {
			return;
		}

		if (param instanceof Map) {
			Map<String, Object> paramMap = (Map<String, Object>) param;
			for (Entry<String, Object> entry : paramMap.entrySet()) {
				if (entry != null) {
					Object val = entry.getValue();
					if (val instanceof List) {
						query.setParameterList(entry.getKey(), (List) entry.getValue());
					} else {
						query.setParameter(entry.getKey(), entry.getValue());
					}

				}
			}
		} else {
			Object[] paramObj = (Object[]) param;
			int size = paramObj.length;
			for (int i = 0; i < size; i++) {
				query.setParameter(i, paramObj[i]);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional("tmTestMaster")
	public List<Object> findparams(String hqlColumn, Object obj, String[][] str) {
		String hql = " from " + getObjectString(obj.toString()) + " o where 1=1";
		if (hqlColumn != null && hqlColumn.length() > 0) {
			hql = "select " + hqlColumn + hql;
		}

		if (str != null && str.length > 0) {
			for (String[] s : str) {
				hql += " and o." + s[0] + " " + s[1] + "'" + s[2] + "'";
			}
		}
		List<Object> result = getTestMasterSession().createQuery(hql).list();
		return result;
	}
	
	protected String getObjectString(String str) {
		String[] tmp = str.split("\\.");
		return tmp[tmp.length - 1];
	}
}