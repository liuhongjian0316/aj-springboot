package work.aijiu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags="用户相关接口", description = "提供用户相关操作RestAPI")
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
    @ApiOperation("注册用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userinfo", value = "用户实体类")
    })
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

    /**
     * 用户分页查询(mybatis-plus 分页插件)
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/page/{start}/{end}")
    public IPage<Userinfo> userPage(@PathVariable("start")Integer start,@PathVariable("end")Integer end){
        return userinfoService.userPage(new Page<>(start,end));
    }

    /**
     * 用户分页查询（pagehelper）
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/page2/{start}/{end}")
    public PageInfo<Userinfo> userPage2(@PathVariable("start")Integer start,@PathVariable("end")Integer end){
        PageHelper.startPage(start,end);
        return new PageInfo<Userinfo>(userinfoService.queryAll());
    }
}