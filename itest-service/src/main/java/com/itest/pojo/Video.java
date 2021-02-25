package com.itest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author ChanV
 * @create 2021-02-25-9:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Video {

    private String video_id;

    private String video_title;

    private String video_url;

    private String video_introduction;

    private Integer video_like;

    private Integer video_comment;

    private Integer video_forward;

    private String user_id;

    private String type_id;

    private Integer is_deleted;

    private Date create_time;


}
