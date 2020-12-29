package com.zlbteam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlbteam.entity.User;
import com.zlbteam.mapper.IUserMapper;
import com.zlbteam.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author zhoulibin
 */
@Service
public class IUserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService{
}
