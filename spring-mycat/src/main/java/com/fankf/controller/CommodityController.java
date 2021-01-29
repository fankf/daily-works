package com.fankf.controller;

import com.fankf.entity.Commodity;
import com.fankf.service.CommodityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Commodity)表控制层
 *
 * @author makejava
 * @since 2021-01-29 10:54:38
 */
@RestController
@RequestMapping("commodity")
public class CommodityController {
    /**
     * 服务对象
     */
    @Resource
    private CommodityService commodityService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Commodity selectOne(Integer id) {
        return this.commodityService.queryById(id);
    }

}