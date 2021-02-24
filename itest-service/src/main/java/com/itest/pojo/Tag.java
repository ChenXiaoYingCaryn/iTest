package com.itest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ChanV
 * @create 2021-02-24-13:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tag {
    private String tag_id;
    private String tag_name;
    private Integer is_deleted;
}
