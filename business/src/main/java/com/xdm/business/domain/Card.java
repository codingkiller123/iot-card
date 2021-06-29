package com.xdm.business.domain;

import com.xdm.common.core.web.domain.BaseEntity;

import java.util.Date;

/**
 * 流量池信息 poll
 *
 * @author xdm
 */
public class Card extends BaseEntity {

    /**
     * 集成电路卡识别码
     */
    private String iccid;

    /**
     * 物联网卡接入号码
     */
    private String msisdn;


    /**
     * 卡可用总量
     */
    private Double flowTotal;

    /**
     * 卡用量
     */
    private Double flowUsed;

    /**
     * 卡剩余用量
     */
    private Double flowLeft;

    /**
     * 卡状态
     * 0：其他
     * 1：待激活
     * 2：沉默期
     * 3：测试期
     * 4：已激活
     * 5：已停机
     * 6：已销户
     * 7：预销户
     */
    private Integer status;

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Double getFlowTotal() {
        return flowTotal;
    }

    public void setFlowTotal(Double flowTotal) {
        this.flowTotal = flowTotal;
    }

    public Double getFlowUsed() {
        return flowUsed;
    }

    public void setFlowUsed(Double flowUsed) {
        this.flowUsed = flowUsed;
    }

    public Double getFlowLeft() {
        return flowLeft;
    }

    public void setFlowLeft(Double flowLeft) {
        this.flowLeft = flowLeft;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Card{" +
                "iccid='" + iccid + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", flowTotal=" + flowTotal +
                ", flowUsed=" + flowUsed +
                ", flowLeft=" + flowLeft +
                ", status=" + status +
                '}';
    }
}
