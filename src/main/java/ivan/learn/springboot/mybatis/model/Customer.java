package ivan.learn.springboot.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Customer {

    private Long id;

    private String name;

    private Boolean gender;

    private Integer age;

    private String phone;

    private String firstName;

    private String lastName;

    private Date createTime;

    private Date updateTime;

}