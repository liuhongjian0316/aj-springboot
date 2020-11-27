package work.aijiu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import work.aijiu.dao.UserinfoDao;
import work.aijiu.entity.JwtUser;
import work.aijiu.entity.Userinfo;

/**
 * 手机号登录
 */
public class MobileLoginServiceImpl implements UserDetailsService {

    @Autowired
    private UserinfoDao userinfoDao;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        QueryWrapper<Userinfo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Userinfo::getMobile,mobile);
        Userinfo user = userinfoDao.selectOne(wrapper);
        if(user == null){
            throw new UsernameNotFoundException("该手机号还未注册");
        }
        return new JwtUser(user);
    }
}
