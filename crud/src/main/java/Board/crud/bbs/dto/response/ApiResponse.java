package board.crud.bbs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;

    // 성공했을 때 데이터 담아보내는 Method
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "요청이 성공적으로 처리되었습니다.", data);
    }

    // 성공했지만 데이터는 필요 없을 때 (예: 삭제 성공 같은)
    public static <T> ApiResponse<T> success() {
        return  new ApiResponse<>(true, "요청이 성공적으로 처리되었습니다.", null);
    }

    // 에러가 났을 때 메시지를 보내는 메서드
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null);
    }
}
