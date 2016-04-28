/**
 * 
 */
package cn.fuyoushuo.crawler.basic;



import java.io.Serializable;
import java.util.List;

/**
 * Base db operation for service
 * 
 * @author yideng
 * @version 1.0
 */
	public interface IBaseService<T, ID extends Serializable> {

	/**
	 * 添加记录
	 *
	 * @param t
	 * @return boolean
	 */
	public void add(T t);

	/**
	 * 删除记录
	 *
	 * @param id
	 *
	 * @return boolean
	 */
	public void delete(ID id);

	/**
	 * 更新记录
	 *
	 * @param t
	 * @return boolean
	 */
	public void update(T t);

	/**
	 * 查找 list 表记录
	 *
	 * @param param
	 * @return List<T>
	 */
	public List<T> findListBy(T param);


	/**
	 * 查找 list 表记录, 按分页查找
	 * T : entity
	 * P : 分页对象
	 * @param param
	 * @return IGenericPage<T>
	 */
	public IGenericPage<T> findPageBy(T param, PageAble p);





}
