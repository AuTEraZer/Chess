package net.plyse.chess.exception;

/**
 * @author Raphael Dichler on 22.12.20
 * @project Chess
 */
public class InvalidOpponentException extends RuntimeException {

    public InvalidOpponentException() {
    }

    public InvalidOpponentException(String message) {
        super(message);
    }

    public InvalidOpponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOpponentException(Throwable cause) {
        super(cause);
    }

    public InvalidOpponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
