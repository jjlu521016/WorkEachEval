package chzu.lujie.work.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	public DaoSupportImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass(); // 获取当前new的对象的
											// 泛型的父类类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		System.out.println("Debug---class--> " + clazz);
	}

	/**
	 * 获取当前可用的Session对象
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(Long id) {
		// 获取对象的id
		Object obj = getById(id);
		// 如果出入的id不为空则删除
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	public T getById(Long id) {
		// 如果id为空则返回null
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	public List<T> getByIds(Long[] ids) {
		if(ids == null){
//			集合最好不要返回null，容易出错
			return Collections.EMPTY_LIST;
		}else{
		return getSession().createQuery(//
				"FROM "+ clazz.getSimpleName() +" WHERE id IN (:ids)")//
				.setParameterList("ids", ids)//
				.list();
		}
	}

	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

}
