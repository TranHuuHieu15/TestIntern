package hieutran.testintern.exception;

import hieutran.testintern.dto.response.ResponseError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

//! Lỗi xảy ra khi không có quyền truy cập (403)
@Getter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
    private ResponseError responseError;
    public ForbiddenException(String message) {
        super(message);
        responseError = ResponseError.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .timestamp(LocalDateTime.now())
                .error(HttpStatus.FORBIDDEN.getReasonPhrase())
                .message(message)
                .build();
    }
}
