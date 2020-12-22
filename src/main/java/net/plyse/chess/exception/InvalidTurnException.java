package net.plyse.chess.exception;

/**
 * @author Raphael Dichler on 22.12.20
 * @project Chess
 */
public class InvalidTurnException extends RuntimeException {

    public InvalidTurnException() {
        super();
    }

    public InvalidTurnException(String message) {
        super(message);
    }

    public InvalidTurnException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTurnException(Throwable cause) {
        super(cause);
    }

    public InvalidTurnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
