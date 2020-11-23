package work.aijiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import work.aijiu.entity.Userinfo;
import work.aijiu.service.UserinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Userinfo)表控制层
 *
 * @author makejava
 * @since 2020-11-23 15:14:13
 */
@RestController
@RequestMapping("user")
public class UserinfoController {
    /**
     * 服务对象
     */
    @Autowired
    private UserinfoService userinfoService;

    /**
     * 注册
     * @param userinfo
     * @return
     */
    @PostMapping("add")
    public Userinfo rigester(@RequestBody Userinfo userinfo){
        return userinfoService.addUser(userinfo);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public Map<String,Object> delUser(@PathVariable("id")long id){
        return userinfoService.delUser(id);
    }

    /**
     * 更新用户
     * @param userinfo
     * @return
     */
    @PutMapping("update")
    public Userinfo updateUser(@RequestBody Userinfo userinfo){
        return userinfoService.updateUser(userinfo);
    }

    /**
     * 查看用户详情
     * @param id
     * @return
     */
    @GetMapping("/details/{id}")
    public Userinfo userDetails(@PathVariable("id") long id){
        return userinfoService.userDetails(id);
    }
}