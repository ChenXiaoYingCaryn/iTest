package com.itest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author ChanV
 * @create 2021-02-24-9:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Type {

    private String type_id;
    private String type_name;
    private String type_image;
    private Integer type_price;
    private String type_classify;
    private String tag_id;
    private Integer is_deleted;
    private Date create_time;

}
