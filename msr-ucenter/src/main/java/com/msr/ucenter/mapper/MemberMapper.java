package com.msr.ucenter.mapper;

import com.msr.ucenter.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author tom
 * @since 2020-06-12
 */
@Repository
public interface MemberMapper extends BaseMapper<Member> {
    /**
     * 根据时间，统计指定时间下注册的人数
     * @param day   时间
     * @return      人数
     */
    Integer selectRegisterCount(String day);
}
