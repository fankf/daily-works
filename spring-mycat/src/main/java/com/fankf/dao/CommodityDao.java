package com.fankf.dao;

import com.fankf.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Commodity)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-29 10:54:29
 */
public interface CommodityDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Commodity queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Commodity> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param commodity 实例对象
     * @return 对象列表
     */
    List<Commodity> queryAll(Commodity commodity);

    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 影响行数
     */
    int insert(Commodity commodity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Commodity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Commodity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Commodity> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Commodity> entities);

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 影响行数
     */
    int update(Commodity commodity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}