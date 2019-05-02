package jukeboxloader.pojo;

public enum JukeMessage {

    SETTING_NOT_FOUND(1, "Could not find setting"),
    JUKEBOX_NOT_FOUND(2, "Could not find jukebox"),
    STATUS_OK(3, "You are up and running");

    private int errorCode;
    private String message;

    JukeMessage(int errorCode, String message) {

        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
