package hieutran.testintern.exception;

import hieutran.testintern.dto.response.ResponseError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

//! Lỗi xảy ra khi có xung đột dữ liệu (Dữ liệu đã tồn tại)
@Getter
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    private ResponseError responseError;

    public ConflictException(String message) {
        super(message);
        responseError = ResponseError.builder()
                .status(HttpStatus.CONFLICT.value())
                .timestamp(LocalDateTime.now())
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .message(message)
                .build();
    }

}
