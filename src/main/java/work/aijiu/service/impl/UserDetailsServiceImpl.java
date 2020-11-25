package work.aijiu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import work.aijiu.dao.UserinfoDao;
import work.aijiu.entity.JwtUser;
import work.aijiu.entity.Userinfo;

/**
 * Created by echisan on 2018/6/23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserinfoDao userinfoDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Userinfo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Userinfo::getUsername,username);
        Userinfo user = userinfoDao.selectOne(wrapper);
        return new JwtUser(user);
    }

}
