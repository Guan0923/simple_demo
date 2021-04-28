package com.guan.simpledemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 8:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity<T> {
    private Integer code;
    private String message;
    private T data;

    public ResultEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }


}
