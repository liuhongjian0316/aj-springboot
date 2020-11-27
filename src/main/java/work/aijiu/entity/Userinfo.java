package work.aijiu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Userinfo)实体类
 *
 * @author makejava
 * @since 2020-11-23 15:14:08
 */
@Data
public class Userinfo implements Serializable {
    private static final long serialVersionUID = 751057039383913906L;
    /**
    * 主键
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 权限
    */
    private String perms;
    /**
    * 角色
    */
    private String role;
    /**
     * 手机号
     */
    private String mobile;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}