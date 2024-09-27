package hieutran.testintern.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ResponseSuccess<T> {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL) //! không trả về giá trị null nếu giá trị data = null
    private T data;
//    //! constructor dùng cho put, path, delete
//    public ResponseSuccess(int status, String message) {
//        this.status = status;
//        this.message = message;
//    }
}
