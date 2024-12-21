package learn.api_basic.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> {
    private Integer status;

    private String message;

    private T data;

    private Object errors;

    @Builder.Default
    private String request_id = UUID.randomUUID().toString();
}
