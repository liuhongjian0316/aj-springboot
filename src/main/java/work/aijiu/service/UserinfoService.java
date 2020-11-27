package work.aijiu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 用户分页
     * @param page
     * @return
     */
    IPage<Userinfo> userPage(Page<Userinfo> page);

    /**
     * 查询全部用户
     * @return
     */
    List<Userinfo> queryAll();

    /**
     * 根据手机号查询用户
     * @param moblie
     * @return
     */
    List<Userinfo> queryByMoblie(String moblie);
}