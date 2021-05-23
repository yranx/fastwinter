package com.ranx.company.model.Do;

import java.io.Serializable;
import java.util.Date;

public class OperateLogDo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.member_id
     *
     * @mbg.generated
     */
    private Long memberId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.belonger_id
     *
     * @mbg.generated
     */
    private Long belongerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.direction
     *
     * @mbg.generated
     */
    private Integer direction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.booking_order_id
     *
     * @mbg.generated
     */
    private Long bookingOrderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.log_content
     *
     * @mbg.generated
     */
    private String logContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.is_read
     *
     * @mbg.generated
     */
    private Integer isRead;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.created_id
     *
     * @mbg.generated
     */
    private Long createdId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.created_name
     *
     * @mbg.generated
     */
    private String createdName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.created_time
     *
     * @mbg.generated
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.last_modified_id
     *
     * @mbg.generated
     */
    private Long lastModifiedId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.last_modified_name
     *
     * @mbg.generated
     */
    private String lastModifiedName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.last_modified_time
     *
     * @mbg.generated
     */
    private Date lastModifiedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.valid
     *
     * @mbg.generated
     */
    private Integer valid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operate_log.is_operate
     *
     * @mbg.generated
     */
    private Integer isOperate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table operate_log
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.id
     *
     * @return the value of operate_log.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.id
     *
     * @param id the value for operate_log.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.member_id
     *
     * @return the value of operate_log.member_id
     *
     * @mbg.generated
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.member_id
     *
     * @param memberId the value for operate_log.member_id
     *
     * @mbg.generated
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.belonger_id
     *
     * @return the value of operate_log.belonger_id
     *
     * @mbg.generated
     */
    public Long getBelongerId() {
        return belongerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.belonger_id
     *
     * @param belongerId the value for operate_log.belonger_id
     *
     * @mbg.generated
     */
    public void setBelongerId(Long belongerId) {
        this.belongerId = belongerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.direction
     *
     * @return the value of operate_log.direction
     *
     * @mbg.generated
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.direction
     *
     * @param direction the value for operate_log.direction
     *
     * @mbg.generated
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.booking_order_id
     *
     * @return the value of operate_log.booking_order_id
     *
     * @mbg.generated
     */
    public Long getBookingOrderId() {
        return bookingOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.booking_order_id
     *
     * @param bookingOrderId the value for operate_log.booking_order_id
     *
     * @mbg.generated
     */
    public void setBookingOrderId(Long bookingOrderId) {
        this.bookingOrderId = bookingOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.type
     *
     * @return the value of operate_log.type
     *
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.type
     *
     * @param type the value for operate_log.type
     *
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.log_content
     *
     * @return the value of operate_log.log_content
     *
     * @mbg.generated
     */
    public String getLogContent() {
        return logContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.log_content
     *
     * @param logContent the value for operate_log.log_content
     *
     * @mbg.generated
     */
    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.is_read
     *
     * @return the value of operate_log.is_read
     *
     * @mbg.generated
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.is_read
     *
     * @param isRead the value for operate_log.is_read
     *
     * @mbg.generated
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.created_id
     *
     * @return the value of operate_log.created_id
     *
     * @mbg.generated
     */
    public Long getCreatedId() {
        return createdId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.created_id
     *
     * @param createdId the value for operate_log.created_id
     *
     * @mbg.generated
     */
    public void setCreatedId(Long createdId) {
        this.createdId = createdId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.created_name
     *
     * @return the value of operate_log.created_name
     *
     * @mbg.generated
     */
    public String getCreatedName() {
        return createdName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.created_name
     *
     * @param createdName the value for operate_log.created_name
     *
     * @mbg.generated
     */
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.created_time
     *
     * @return the value of operate_log.created_time
     *
     * @mbg.generated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.created_time
     *
     * @param createdTime the value for operate_log.created_time
     *
     * @mbg.generated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.last_modified_id
     *
     * @return the value of operate_log.last_modified_id
     *
     * @mbg.generated
     */
    public Long getLastModifiedId() {
        return lastModifiedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.last_modified_id
     *
     * @param lastModifiedId the value for operate_log.last_modified_id
     *
     * @mbg.generated
     */
    public void setLastModifiedId(Long lastModifiedId) {
        this.lastModifiedId = lastModifiedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.last_modified_name
     *
     * @return the value of operate_log.last_modified_name
     *
     * @mbg.generated
     */
    public String getLastModifiedName() {
        return lastModifiedName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.last_modified_name
     *
     * @param lastModifiedName the value for operate_log.last_modified_name
     *
     * @mbg.generated
     */
    public void setLastModifiedName(String lastModifiedName) {
        this.lastModifiedName = lastModifiedName == null ? null : lastModifiedName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.last_modified_time
     *
     * @return the value of operate_log.last_modified_time
     *
     * @mbg.generated
     */
    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.last_modified_time
     *
     * @param lastModifiedTime the value for operate_log.last_modified_time
     *
     * @mbg.generated
     */
    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.valid
     *
     * @return the value of operate_log.valid
     *
     * @mbg.generated
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.valid
     *
     * @param valid the value for operate_log.valid
     *
     * @mbg.generated
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operate_log.is_operate
     *
     * @return the value of operate_log.is_operate
     *
     * @mbg.generated
     */
    public Integer getIsOperate() {
        return isOperate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operate_log.is_operate
     *
     * @param isOperate the value for operate_log.is_operate
     *
     * @mbg.generated
     */
    public void setIsOperate(Integer isOperate) {
        this.isOperate = isOperate;
    }
}