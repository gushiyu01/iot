package com.ictbda.iot.dao;

import com.ictbda.iot.entity.EqTrace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * (EqTrace)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-10 14:04:54
 */
@Mapper
public interface EqTraceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EqTrace queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EqTrace> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param eqTrace 实例对象
     * @return 对象列表
     */
    List<EqTrace> queryAll(EqTrace eqTrace);

    /**
     * 新增数据
     *
     * @param eqTrace 实例对象
     * @return 影响行数
     */
    int insert(EqTrace eqTrace);

    /**
     * 修改数据
     *
     * @param eqTrace 实例对象
     * @return 影响行数
     */
    int update(EqTrace eqTrace);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据起止时间查轨迹
     * @param map
     * @return
     */
    List<EqTrace> queryEqTraceByTime(HashMap<String, Object> map);

}