package work.aijiu.service;

import work.aijiu.entity.Userinfo;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据id 删除用户
     * @param id
     * @return
     */
    Map<String,Object> delUser(long id);

    /**
     * 更新用户
     * @param userinfo
     * @return
     */
    Userinfo updateUser(Userinfo userinfo);

    /**
     * 用户详情
     * @param id
     * @return
     */
    Userinfo userDetails(long id);
}