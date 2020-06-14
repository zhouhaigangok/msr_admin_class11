package com.msr.ucenter.service.impl;

import com.msr.ucenter.entity.Member;
import com.msr.ucenter.mapper.MemberMapper;
import com.msr.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author tom
 * @since 2020-06-12
 *
 * 业务层实现类,调用mapper层中的方法
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    //定义mapper层的接口对象
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Integer countRegisterByDay(String day) {
        return memberMapper.selectRegisterCount(day);
    }
}
