package veterinaria.data.data.exceptions;

public class ExceptionDao extends Exception{
    public ExceptionDao() {
        super();
    }

    public ExceptionDao(String message) {
        super(message);
    }

    public ExceptionDao(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionDao(Throwable cause) {
        super(cause);
    }

    protected ExceptionDao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
