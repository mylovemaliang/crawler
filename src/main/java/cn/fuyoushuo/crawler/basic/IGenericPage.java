/**
 * 
 */
package cn.fuyoushuo.crawler.basic;

import java.util.List;

/**
 * 支持泛型的分页数据接口
 * 
 * @author 赵士杰
 *
 * @param <T>
 */
public abstract class IGenericPage<T> {


	private PageAble page;

	public PageAble getPage() {
		return page;
	}

	public void setPage(PageAble page) {
		this.page = page;
	}

	IGenericPage(PageAble page){this.page = page;}

	/**
	 * 是否为第一页
	 *
	 * @return 是否为第一页
	 */
	abstract boolean isFirstPage();

	/**
	 * 是否为最后一页
	 * 
	 * @return 是否为最后一页
	 */
	abstract boolean isLastPage();

	/**
	 * 有无下一页
	 * 
	 * @return 真(true)为有下一页，假(false)为无
	 */
	abstract boolean hasNextPage() ;

	/**
	 * 有无上一页
	 * 
	 * @return 真(true)为有上一页，假(false)为无
	 */
	abstract boolean hasPreviousPage() ;

	/**
	 * 得到最后一页的页号
	 * 
	 * @return 最后一页的页号
	 */
	abstract int getLastPageNo() ;

	/**
	 * 获取当前页中包含的数据
	 * 
	 * @return 当前页中包含的数据
	 */
	abstract List<T> getThisPageElements();

	/**
	 * 得到数据总个数
	 * 
	 * @return 数据总个数
	 */
	abstract int getTotalCount() ;

	/**
	 * 获取当前页第一条记录在所有记录的编号，即数据项范围上标
	 * 
	 * @return 当前页第一条记录在所有记录的编号
	 */
	abstract int getThisPageFirstElementNumber() ;

	/**
	 * 获取当前页最后一条记录在所有记录的编号
	 * 
	 * @return 当前页最后一条记录在所有记录的编号
	 */
	abstract int getThisPageLastElementNumber() ;

	/**
	 * 得到下一页的页号
	 * 
	 * @return 下一页的页号
	 */
	abstract int getNextPageNo();

	/**
	 * 得到前一页的页号
	 * 
	 * @return 前一页的页号
	 */
	abstract int getPreviousPageNo();

	/**
	 * 得到设定的页大小（每页数据个数）
	 * 
	 * @return 页大小 （每页数据个数）
	 */
	abstract int getPageSize();

	/**
	 * 得到当前页的页号
	 * 
	 * @return 当前页的页号
	 */
	abstract int getPageNo();

}
