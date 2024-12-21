package learn.api_basic.exception;

public class ApiException extends RuntimeException {
    public ApiException(String messsage) {
        super(messsage);
    }
}
