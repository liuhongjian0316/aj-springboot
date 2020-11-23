package work.aijiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import work.aijiu.entity.Userinfo;
import work.aijiu.service.UserinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Userinfo)表控制层
 *
 * @author makejava
 * @since 2020-11-23 15:14:13
 */
@RestController
@RequestMapping("userinfo")
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
    public Userinfo rigester(Userinfo userinfo){
        return userinfoService.addUser(userinfo);
    }
}