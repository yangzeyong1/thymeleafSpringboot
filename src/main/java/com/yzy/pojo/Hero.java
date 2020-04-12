package com.yzy.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "tb_hero")
public class Hero implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String profession;
    private String phone;

    /*//@Transient注解的作用是：查询表的时候，该字段不参与
    @Transient*/
    private String email;
    private Date onlinetime;
}