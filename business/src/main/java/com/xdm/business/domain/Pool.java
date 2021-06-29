package com.xdm.business.domain;

import com.xdm.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 流量池信息 poll
 *
 * @author xdm
 */
public class Pool extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 流量池编号
     */
    private Long id;

    /**
     * 流量池名称
     */
    private String poolName;

    /**
     * 商户名称
     */
    private String customerName;

    /**
     * 卡数量
     */
    private Long cardNum;

    /**
     * 激活卡数量
     */
    private Long activateCardNum;

    /**
     * 流量总量(MB)
     */
    private Double totalFlowNum;

    /**
     * 当月总用量（MB）
     */
    private Double totalUseFlowNum;

    /**
     * 当月剩余使用量(MB)
     */
    private Double totalSurplusFlowNum;

    /**
     * 使用占比
     */
    private Double flowUseRatio;

    /**
     * 停机阈值(MB)
     */
    private Double stopThreshold;

    /**
     * SYSTEM =系统流量池
     */
    private String poolType;

    /**
     * 创建时间
     */
    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCardNum() {
        return cardNum;
    }

    public void setCardNum(Long cardNum) {
        this.cardNum = cardNum;
    }

    public Long getActivateCardNum() {
        return activateCardNum;
    }

    public void setActivateCardNum(Long activateCardNum) {
        this.activateCardNum = activateCardNum;
    }

    public Double getTotalFlowNum() {
        return totalFlowNum;
    }

    public void setTotalFlowNum(Double totalFlowNum) {
        this.totalFlowNum = totalFlowNum;
    }

    public Double getTotalUseFlowNum() {
        return totalUseFlowNum;
    }

    public void setTotalUseFlowNum(Double totalUseFlowNum) {
        this.totalUseFlowNum = totalUseFlowNum;
    }

    public Double getTotalSurplusFlowNum() {
        return totalSurplusFlowNum;
    }

    public void setTotalSurplusFlowNum(Double totalSurplusFlowNum) {
        this.totalSurplusFlowNum = totalSurplusFlowNum;
    }

    public Double getFlowUseRatio() {
        return flowUseRatio;
    }

    public void setFlowUseRatio(Double flowUseRatio) {
        this.flowUseRatio = flowUseRatio;
    }

    public Double getStopThreshold() {
        return stopThreshold;
    }

    public void setStopThreshold(Double stopThreshold) {
        this.stopThreshold = stopThreshold;
    }

    public String getPoolType() {
        return poolType;
    }

    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "id=" + id +
                ", poolName='" + poolName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", cardNum=" + cardNum +
                ", activateCardNum=" + activateCardNum +
                ", totalFlowNum=" + totalFlowNum +
                ", totalUseFlowNum=" + totalUseFlowNum +
                ", totalSurplusFlowNum=" + totalSurplusFlowNum +
                ", flowUseRatio=" + flowUseRatio +
                ", stopThreshold=" + stopThreshold +
                ", poolType='" + poolType + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
