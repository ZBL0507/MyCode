package com.zbl.dto;

import lombok.Data;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/12/22 21:16
 */
@Data
public class FieldDTO {
    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 字段注释
     */
    private String fieldComment;
}
