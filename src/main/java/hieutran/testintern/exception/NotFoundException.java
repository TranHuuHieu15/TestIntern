package hieutran.testintern.exception;

import hieutran.testintern.dto.response.ResponseError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private ResponseError responseError;

    public NotFoundException(String message) {
        super(message);
        responseError = ResponseError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(message)
                .build();
    }

}
