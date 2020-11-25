package work.aijiu.common.utils;

/**
 * @ClassName JSONResult
 * @Description 自定义响应数据格（接口）
 *              200：表示成功
 *              500：表示错误
 *              501：bean验证错误
 *              502：拦截器拦截用户taken出错
 *              503：不具备角色功能
 *              505：异常抛出信息
 * @Author liuhongjian
 * @Date 2020/3/11 16:03
 * @Version 1.0
 **/
public class JSONResult {

    /**
     * 响应码
     */
    private Integer status;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应的数据
     */
    private Object data;

    /**
     *
     */
    private String ok;

    public static JSONResult build(Integer status,String msg,Object data){
        return new JSONResult(status,msg,data);
    }
    public static JSONResult ok(Object data){
        return new JSONResult(data);
    }
    public static JSONResult ok(){
        return new JSONResult(null);
    }
    public static JSONResult errorMsg(String msg){
        return new JSONResult(500,msg,null);
    }
    public static JSONResult errorMap(Object data){
        return new JSONResult(501,"error",data);
    }
    public static JSONResult errorTokenMsg(String msg){
        return new JSONResult(502,msg,null);
    }
    public static JSONResult errorRolesMsg(String msg){
        return new JSONResult(503,msg,null);
    }
    public static JSONResult errorException(String msg){
        return new JSONResult(555,msg,null);
    }

    public JSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult() {
    }

    public JSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOk(){
        return this.status ==200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}
