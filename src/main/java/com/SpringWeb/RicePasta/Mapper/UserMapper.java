package com.SpringWeb.RicePasta.Mapper;

import com.SpringWeb.RicePasta.VO.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(UserVO userVO);
}