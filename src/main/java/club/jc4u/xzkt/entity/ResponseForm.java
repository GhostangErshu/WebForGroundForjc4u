package club.jc4u.xzkt.entity;

/**
 * @Author TangXi
 * @Date 19-8-29 下午5:39
 */
public class ResponseForm {
    private boolean status = false;
    private Object content;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        StringBuffer temp = new StringBuffer();
        if (this.error!=null)
        //先把上一次的错误信息保存
            temp.append(this.error);
        //保存当前的错误信息
        this.error = temp.append("@"+error).toString();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
