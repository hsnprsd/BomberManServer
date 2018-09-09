package ir.bomberman.server.responses;

public class Response {
    private boolean successful;
    private int errorCode;
    private String data;

    public boolean isSuccessful() {
        return successful;
    }

    public void success() {
        successful = true;
    }

    public void success(String data) {
        successful = true;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
