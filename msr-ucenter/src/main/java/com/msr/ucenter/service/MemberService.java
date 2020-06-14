package com.msr.ucenter.service;

import com.msr.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author tom
 * @since 2020-06-12
 */
public interface MemberService extends IService<Member> {
    Integer countRegisterByDay(String day);
}
