package work.aijiu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import work.aijiu.entity.Userinfo;
import work.aijiu.dao.UserinfoDao;
import work.aijiu.service.UserinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Userinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-23 15:14:12
 */
@Transactional
@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoDao userinfoDao;

    @Override
    public Userinfo addUser(Userinfo userinfo) {
        try {
            int insert = userinfoDao.insert(userinfo);
            return userinfo;
        } catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return null;
    }

    @Override
    public Map<String, Object> delUser(long id) {
        Map<String,Object> map = new HashMap<>();
        try{
            if(userinfoDao.deleteById(id)>0){
                map.put("msg","success");
                map.put("status","success");
                map.put("code","200");
                return map;
            }else {
                map.put("msg","failure");
                map.put("status","failure");
                map.put("code","500");
                return map;
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        map.put("msg","failure");
        map.put("status","failure");
        map.put("code","500");
        return map;
    }

    @Override
    public Userinfo updateUser(Userinfo userinfo) {
        try {
            int result = userinfoDao.updateById(userinfo);
            return userinfo;
        } catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return null;
    }

    @Override
    public Userinfo userDetails(long id) {
        try {
            return userinfoDao.selectById(id);
        } catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return null;
    }

}