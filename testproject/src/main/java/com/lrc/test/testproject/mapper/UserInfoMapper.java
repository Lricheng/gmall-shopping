package com.lrc.test.testproject.mapper;

import com.lrc.test.testproject.bean.UserInfo;
import tk.mybatis.mapper.common.Mapper;
//mapper 泛型 表示mapper要操作的实体类

public interface UserInfoMapper extends Mapper<UserInfo> {
}
