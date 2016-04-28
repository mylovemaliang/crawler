/**
 *
 */
package cn.fuyoushuo.crawler.basic;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 抽象的 db 服务
 *
 * @param <T>  entity类型
 * @param <D>  mybatis mapper实现类
 * @param <ID> 查找删除使用的id
 * @author yideng
 * @version 1.0
 */
public abstract class BaseService<T, D extends BaseMapper<T,ID>, ID extends Serializable> implements
        IBaseService<T, ID> {

    /**
     * db service implements
     */
    protected D Mapper;

    /**
     * 添加记录
     *
     * @param t
     * @return boolean
     */
    public void add(T t) {
        this.Mapper.add(t);
    }

    /**
     * 删除记录
     *
     * @param id
     * @return boolean
     */
    public void delete(ID id) {
        this.Mapper.delete(id);
    }

    /**
     * 更新记录
     *
     * @param t
     * @return boolean
     */
    public void update(T t) {
        this.Mapper.update(t);
    }

    /**
     * 查找 list 表记录
     *
     * @param param
     * @return List<T>
     */
    public List<T> findListBy(T param) {
          return this.Mapper.selectList(param);
    }

    /**
     * 查找 list 表记录, 按分页查找
     *
     * @param param    <parameter>
     * @return IGenericPage<T>
     */
    public IGenericPage<T> findPageBy(T param, final PageAble page) {
        final List<T> list = this.getPagedData(param,page);
        return new IGenericPage<T>(page){
            @Override
            public boolean isFirstPage() {
                return page.getPage() == 1;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean hasNextPage() {
                return false;
            }

            @Override
            public boolean hasPreviousPage() {
                return false;
            }

            @Override
            public int getLastPageNo() {
                return 0;
            }

            @Override
            public List<T> getThisPageElements() {
                if(!CollectionUtils.isEmpty(list)){
                  return list;
                }
                return new ArrayList<T>();
            }

            @Override
            public int getTotalCount() {
                return page.getTotal();
            }

            @Override
            public int getThisPageFirstElementNumber() {
                return 0;
            }

            @Override
            public int getThisPageLastElementNumber() {
                return 0;
            }

            @Override
            public int getNextPageNo() {
                return 0;
            }

            @Override
            public int getPreviousPageNo() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return page.getRows();
            }

            @Override
            public int getPageNo() {
                return page.getPage();
            }
        };

    }

    public List<T> getPagedData(T param,PageAble page){
        return this.Mapper.selectPage(param,page);
    }

    public D getMapper() {
        return Mapper;
    }


    public void setMapper(D mapper) {
        Mapper = mapper;
    }


}
