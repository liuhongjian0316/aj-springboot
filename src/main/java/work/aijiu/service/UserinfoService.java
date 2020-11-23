package work.aijiu.service;

import work.aijiu.entity.Userinfo;
import java.util.List;

/**
 * (Userinfo)表服务接口
 *
 * @author makejava
 * @since 2020-11-23 15:14:10
 */
public interface UserinfoService {

    /**
     * 增加用户
     * @param userinfo
     * @return
     */
    Userinfo addUser(Userinfo userinfo);

}