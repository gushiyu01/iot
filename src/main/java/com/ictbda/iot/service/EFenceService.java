package com.ictbda.iot.service;

import com.ictbda.iot.entity.EFence;
import java.util.List;

/**
 * 电子围栏表(EFence)表服务接口
 *
 * @author makejava
 * @since 2020-06-09 10:16:34
 */
public interface EFenceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EFence queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EFence> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param eFence 实例对象
     * @return 实例对象
     */
    EFence insert(EFence eFence);

    /**
     * 修改数据
     *
     * @param eFence 实例对象
     * @return 实例对象
     */
    EFence update(EFence eFence);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据使用者id查询其电子围栏信息
     * @param id
     * @return
     */
    List<EFence> queryByUserId(Long id);

}