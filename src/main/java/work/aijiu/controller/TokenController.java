package work.aijiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getToken")
    public Map<String,String> getToken(@RequestParam("username") String key){
        Map<String,String> userToken = new HashMap<>();
        userToken.put("token",stringRedisTemplate.opsForValue().get(key));
        return userToken;
    }
    @GetMapping("/getUsername")
    public Map<String,Object> getToken(HttpServletRequest request){
        Map<String,Object> userToken = new HashMap<>();
        userToken.put("username",request.getSession().getAttribute("username"));
        return userToken;
    }
}
