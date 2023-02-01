package com.SpringWeb.RicePasta.Service;
/*
 * 스프링은 직접 클래스를 생성하는 것을 지양(안함)하고,
 * 인터페이스를 통해 접근하는 것을 권장하는 프레임워크.
 */
import com.SpringWeb.RicePasta.Mapper.UserMapper;
import com.SpringWeb.RicePasta.VO.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    @Autowired
    UserMapper userMapper;

    @Transactional
    public void joinUser(UserVO userVO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setUserPw(passwordEncoder.encode(userVO.getUserPw()));
        userVO.setUserAuth("USER");
        userVO.setAppendDate(localTime);
        userVO.setUpdateDate(localTime);
        userMapper.saveUser(userVO);
   }

}