package com.huangdekai.JavaWeb.mySMBMS.pojo;

import java.util.Date;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/14 21:37
 * @Version: 1.0
 * @since: jdk11
 */
public class Address {
    private Integer id; // id
    private String contact; // 联系人姓名
    private String addressDesc; // 收货地址明细
    private String postCode;    // 邮政编码
    private String tel;         // 电话号码
    private Integer createdBy;  // 创建者Id
    private Date creationDate;  // 创建日期
    private Integer modifyBy;   // 修改者Id
    private Date modifyDate;    // 修改日期
    private Integer userId;     // 用户Id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
