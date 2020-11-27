package work.aijiu.common.utils.phoneVerify.service;

import com.github.qcloudsms.*;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import work.aijiu.common.utils.phoneVerify.component.PhoneRandomBuilder;
import work.aijiu.common.utils.phoneVerify.util.SMSUtil;

import java.io.IOException;

/**
 * @ClassName SMSService
 * @Description 腾讯短信服务类
 * @Author liuhongjian
 * @Date 2020/3/13 16:03
 * @Version 1.0
 **/
@Service
public class SMSService {

    /**
     * 自定义短信内容发送
     * @param msg 短信内容
     * @param number 用户手机号
     * @return OK 成功  null 失败
     */
    public String sendMess(String msg, String number){
        try {
            SmsSingleSender ssender = new SmsSingleSender(SMSUtil.APPID, SMSUtil.APPKEY);
            SmsSingleSenderResult result = ssender.send(0, "86", number,
                    msg, "", "");
            System.out.print(result);
            return result.errMsg;
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 指定模板ＩＤ发送短信
     * @param number 用户手机号
     * @param mark 0 -- 注册验证   1 -- 修改密码验证
     * @return OK 成功  null 失败
     */
    public String sendMesModel(String number, Integer mark){
        try {
            // 验证码随机数
            String code = PhoneRandomBuilder.randomBuilder();
            //看自己模板参数设置
            String[] params = new String[2];
            params[0] = code;
            params[1] = "5";

            SmsSingleSender ssender = new SmsSingleSender(SMSUtil.APPID, SMSUtil.APPKEY);
            if(mark == 0){
                SmsSingleSenderResult result = ssender.sendWithParam("86", number,
                        SMSUtil.SHORTNOTID, params, SMSUtil.NOTESIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
                return result.errMsg;//OK
            }else if(mark == 1){
                SmsSingleSenderResult result = ssender.sendWithParam("86", number,
                        SMSUtil.UPDPWDID, params, SMSUtil.NOTESIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
                return result.errMsg;//OK
            }
        }catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 群发自定义短信
     * @param msg 短信内容
     * @param numbers 用户手机号数组
     * @return OK 成功 null 失败
     */
    public String sendMesModel(String msg, String[] numbers){
        try {
            SmsMultiSender msender = new SmsMultiSender(SMSUtil.APPID, SMSUtil.APPKEY);
            SmsMultiSenderResult result =  msender.send(0, "86", numbers,
                    msg, "", "");
            System.out.print(result);
            return result.errMsg;
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 指定模板ID群发
     * @param numbers 用户手机号数组
     * @return OK 成功 null 失败
     */
    public String sendMesModel(String[] numbers){
        try {
            String[] params = {"hello" , "1" };
            SmsMultiSender msender = new SmsMultiSender(SMSUtil.APPID, SMSUtil.APPKEY);
            SmsMultiSenderResult result =  msender.sendWithParam("86", numbers,
                    SMSUtil.SHORTNOTID, params, SMSUtil.NOTESIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.print(result);
            return result.errMsg;
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 发送语音消息
     * @param number 用户手机号
     * @param msg 语音消息内容
     * @return OK 成功 null 失败
     */
    public String sendMesVoice(String msg, String number){
        try {
            SmsVoiceVerifyCodeSender vvcsender = new SmsVoiceVerifyCodeSender(SMSUtil.APPID, SMSUtil.APPKEY);
            SmsVoiceVerifyCodeSenderResult result = vvcsender.send("86",number,
                    msg, 2, "");
            System.out.print(result);
            return result.errMsg;
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return null;
    }

}

