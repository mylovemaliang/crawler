package cn.fuyoushuo.crawler.basic;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by QA on 2015/10/28.
 */
public interface BaseMapper<T,I extends Serializable> {

      List<T> selectList(T t);

      List<T> selectPage(@Param("data") T t, @Param("page") PageAble page);

      void add(T t);

      void update(T t);

      void delete(I i);

}
