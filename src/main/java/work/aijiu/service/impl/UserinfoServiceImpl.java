package work.aijiu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import work.aijiu.entity.Userinfo;
import work.aijiu.dao.UserinfoDao;
import work.aijiu.service.UserinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Userinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-23 15:14:12
 */
@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoDao userinfoDao;

    @Override
    public Userinfo addUser(Userinfo userinfo) {
        int insert = userinfoDao.insert(userinfo);
        return userinfo;
    }
}