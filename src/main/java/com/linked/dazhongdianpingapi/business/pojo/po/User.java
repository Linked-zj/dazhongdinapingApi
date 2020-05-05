package com.linked.dazhongdianpingapi.business.pojo.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Linked
 * @date 2020/3/14 16:41
 */

@Data
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;
  
  private String name;
  
  private String telephone;
  
  private String password;
  
  private Integer gender;
  
  private Integer role;

  private Date createTime;

  private String birthday;



}
