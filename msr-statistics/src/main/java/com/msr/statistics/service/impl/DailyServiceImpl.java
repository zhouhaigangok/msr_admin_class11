package com.msr.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.statistics.entity.Daily;
import com.msr.statistics.feign.UcenterFeignService;
import com.msr.statistics.mapper.DailyMapper;
import com.msr.statistics.service.DailyService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author tom
 * @since 2020-06-12
 */


@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements DailyService {
    //调用feign接口
    @Autowired
    private UcenterFeignService ucenterFeignService;

    /**
     * 创建"统计对象"
     * @param day
     * @return
     */
    @Override
    public Integer createStatisticsByDay(String day) {
        //根据时间，获取注册人数（远程调用）
        Integer registerNum =(Integer) ucenterFeignService.registerCount(day).getData().get("countRegister");

        System.out.println("day:"+day);
        System.out.println("registerNum:"+registerNum);

        /**
         * 随机生成数字
         */
        Integer loginNum = RandomUtils.nextInt(100, 200);//TODO
        Integer videoViewNum = RandomUtils.nextInt(100, 200);//TODO
        Integer courseNum = RandomUtils.nextInt(100, 200);//TODO

        //创建“统计对象”
        Daily daily = new Daily();
        daily.setRegisterNum(registerNum);

        daily.setLoginNum(loginNum);
        daily.setVideoViewNum(videoViewNum);
        daily.setCourseNum(courseNum);
        daily.setDateCalculated(day);

        baseMapper.insert(daily);

        return registerNum;
    }
}
