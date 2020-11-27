package work.aijiu.common.utils.phoneVerify.component;

import org.springframework.stereotype.Component;

/**
 * @ClassName PhoneRandomBuilder
 * @Description 手机验证码随机生成
 * @Author liuhongjian
 * @Date 2020/3/13 16:03
 * @Version 1.0
 **/
@Component
public class PhoneRandomBuilder {

    public static String randomBuilder(){
        String result = "";
        for(int i=0;i<4;i++){
            result += Math.round(Math.random() * 9);
        }

        return result;

    }

}
