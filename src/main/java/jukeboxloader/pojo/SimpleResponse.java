package jukeboxloader.pojo;

public class SimpleResponse {
    private int errorCode;
    private String message;

    public SimpleResponse(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
