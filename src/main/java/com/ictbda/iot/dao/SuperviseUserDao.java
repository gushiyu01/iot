package com.ictbda.iot.dao;

import com.ictbda.iot.entity.SuperviseUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 监管人员信息表(SuperviseUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-09 10:16:10
 */
@Mapper
public interface SuperviseUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SuperviseUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SuperviseUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param superviseUser 实例对象
     * @return 对象列表
     */
    List<SuperviseUser> queryAll(SuperviseUser superviseUser);

    /**
     * 新增数据
     *
     * @param superviseUser 实例对象
     * @return 影响行数
     */
    int insert(SuperviseUser superviseUser);

    /**
     * 修改数据
     *
     * @param superviseUser 实例对象
     * @return 影响行数
     */
    int update(SuperviseUser superviseUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}