package com.fankf.service.impl;

import com.fankf.dao.s1.CommodityDao;
import com.fankf.entity.Commodity;
import com.fankf.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Commodity)表服务实现类
 *
 * @author makejava
 * @since 2021-01-29 11:15:25
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityDao commodityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Commodity queryById(Integer id) {
        return this.commodityDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Commodity> queryAllByLimit(int offset, int limit) {
        return this.commodityDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @Override
    public Commodity insert(Commodity commodity) {
        this.commodityDao.insert(commodity);
        return commodity;
    }

    /**
     * 修改数据
     *
     * @param commodity 实例对象
     * @return 实例对象
     */
    @Override
    public Commodity update(Commodity commodity) {
        this.commodityDao.update(commodity);
        return this.queryById(commodity.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.commodityDao.deleteById(id) > 0;
    }
}