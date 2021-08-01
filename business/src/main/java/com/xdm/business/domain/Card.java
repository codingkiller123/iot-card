package com.xdm.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xdm.common.core.web.domain.BaseEntity;
import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     * 移动用户识别码
     */
    private String imsi;

    /**
     * 终端设备识别码
     */
    private String imei;
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
     * 激活时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date activationTime;

    /**
     * 失效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date overTime;

    /**
     * 本月流量使用量 （单位：KB）
     */
    private Double currentMonthUsed;

    /**
     * 卡在线状态 0：离线 1：在线（暂无）
     */
    private Integer onLineStatus;

    /**
     * 设备开关机状态 0：关机 1：开机（暂无）
     */
    private Integer onOffStatus;

    /**
     * 卡所在流量池编号(非池卡该值为空)
     */
    private Double systemPoolId;

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

    private List<CardOrder> cardOrderedPackageVOList = new ArrayList<>();

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

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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

    public Date getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Date activationTime) {
        this.activationTime = activationTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Double getCurrentMonthUsed() {
        return currentMonthUsed;
    }

    public void setCurrentMonthUsed(Double currentMonthUsed) {
        this.currentMonthUsed = currentMonthUsed;
    }

    public Integer getOnLineStatus() {
        return onLineStatus;
    }

    public void setOnLineStatus(Integer onLineStatus) {
        this.onLineStatus = onLineStatus;
    }

    public Integer getOnOffStatus() {
        return onOffStatus;
    }

    public void setOnOffStatus(Integer onOffStatus) {
        this.onOffStatus = onOffStatus;
    }

    public Double getSystemPoolId() {
        return systemPoolId;
    }

    public void setSystemPoolId(Double systemPoolId) {
        this.systemPoolId = systemPoolId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<CardOrder> getCardOrderedPackageVOList() {
        return cardOrderedPackageVOList;
    }

    public void setCardOrderedPackageVOList(List<CardOrder> cardOrderedPackageVOList) {
        this.cardOrderedPackageVOList = cardOrderedPackageVOList;
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
