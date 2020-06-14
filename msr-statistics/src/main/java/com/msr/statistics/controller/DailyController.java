package com.msr.statistics.controller;


import com.msr.common.vo.R;
import com.msr.statistics.entity.Daily;
import com.msr.statistics.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-06-12
 */
@CrossOrigin
@RestController
@RequestMapping("/statistics/daily")
public class DailyController {
    @Autowired
    private DailyService dailyService;

    @GetMapping("/list")
    public R list(){
        List<Daily> list = dailyService.list(null);
        return R.ok().data("list",list);
    }
}

