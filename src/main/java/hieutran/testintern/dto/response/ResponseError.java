package hieutran.testintern.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ResponseError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
}
