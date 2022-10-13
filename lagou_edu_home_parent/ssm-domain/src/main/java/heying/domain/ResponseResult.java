package heying.domain;

public class ResponseResult {

    private Boolean success;
    private int state;
    private String message;
    private Object content;

    public ResponseResult() {
    }

    public ResponseResult(Boolean success, int state, String message, Object content) {
        this.success = success;
        this.state = state;
        this.message = message;
        this.content = content;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
