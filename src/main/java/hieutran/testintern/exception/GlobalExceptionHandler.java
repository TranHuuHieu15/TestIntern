package hieutran.testintern.exception;

import hieutran.testintern.dto.response.ResponseError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConflictException.class)
    public ResponseError handleConflictException(ConflictException ex) {
        return ex.getResponseError();
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseError handleForbiddenException(ForbiddenException ex) {
        return ex.getResponseError();
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseError handleUnauthorizedException(UnauthorizedException ex) {
        return ex.getResponseError();
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseError handleNotFoundException(NotFoundException ex) {
        return ex.getResponseError();
    }
}
