package work.aijiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.aijiu.common.utils.JSONResult;
import work.aijiu.common.utils.Constant;
import work.aijiu.common.utils.RedisOperator;
import work.aijiu.common.utils.phoneVerify.service.SMSService;
import work.aijiu.entity.Userinfo;
import work.aijiu.service.UserinfoService;

/**
 * @ClassName RegisterController
 * @Description 注册
 * @Author liuhongjian
 * @Date 2020/3/13 16:04
 * @Version 1.0
 **/
@RestController
public class SMSController {

    @Autowired
    private RedisOperator redisOperator;

    @Autowired
    private SMSService smsService;

    @Autowired
    private UserinfoService userinfoService;

    /**
     * 注册用户
     * @param users
     * @return
     */
    @PostMapping("register")
    public JSONResult register(@RequestBody Userinfo users){
        userinfoService.addUser(users);
        redisOperator.del(Constant.USER_PHONE_CODE+users.getMobile());
        return JSONResult.ok();
    }


    /**
     * 手机号检测
     * @param phone
     * @return 不存在 -- ok()     存在 -- errorMsg("该手机号已被注册")
     */
    @GetMapping("phoneCheck")
    public JSONResult phoneCheck(@RequestParam("phone") String phone){
        // 先从缓存中查询
        if(redisOperator.hsize(Constant.USER_PHONE_EXIST) != 0){
            if(!redisOperator.hasHkey(Constant.USER_PHONE_EXIST, phone)){
                return JSONResult.ok();
            }else{
                return JSONResult.errorMsg("该手机号已被注册");
            }
        }else{
            int count = userinfoService.queryByMoblie(phone).size();
            if(count <= 0){
                return JSONResult.ok();
            }else{
                return JSONResult.errorMsg("该手机号已被注册");
            }
        }
    }

    /**
     *  获取验证码(点击按钮) -- 注册
     * @param phone 手机号
     * @return
     */
    @GetMapping("getCode")
    public JSONResult getCode(@RequestParam("phone") String phone){
        String s = smsService.sendMesModel(phone, 0);
        if(s.equals("OK")){
            return JSONResult.ok();
        }else{
            return JSONResult.errorMsg("获取验证码失败");
        }
    }

    /**
     *  获取验证码(五分钟输入正确验证码即可)
     * @param phone 手机号
     * @return
     */
    @GetMapping("getCodeReflush")
    public JSONResult getCodeReflush(@RequestParam("phone") String phone){
        if(redisOperator.hasKey(Constant.USER_PHONE_CODE+phone)){
            return JSONResult.ok(redisOperator.get(Constant.USER_PHONE_CODE+phone));
        }else{
            return JSONResult.errorMsg("验证码失效");
        }
    }

}