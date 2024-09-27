package hieutran.testintern.exception;

import hieutran.testintern.dto.response.ResponseError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

//! Lỗi xảy ra khi không có quyền truy cập (401)
@Getter
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    private ResponseError responseError;
    public UnauthorizedException(String message) {
        super(message);
        responseError = ResponseError.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .timestamp(LocalDateTime.now())
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .message(message)
                .build();
    }
}
