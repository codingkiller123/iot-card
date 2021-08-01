package com.xdm.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CardOrder {

    /**
     *套餐编号
     */
    private Double itemId;

    /**
     *套餐名称
     */
    private String itemName;

    /**
     *生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date itemEffectiveTime;

    /**
     *失效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date itemOverTime;

    private String basePricing;

    public String getBasePricing() {
        return basePricing;
    }

    public void setBasePricing(String basePricing) {
        this.basePricing = basePricing;
    }

    public Double getItemId() {
        return itemId;
    }

    public void setItemId(Double itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getItemEffectiveTime() {
        return itemEffectiveTime;
    }

    public void setItemEffectiveTime(Date itemEffectiveTime) {
        this.itemEffectiveTime = itemEffectiveTime;
    }

    public Date getItemOverTime() {
        return itemOverTime;
    }

    public void setItemOverTime(Date itemOverTime) {
        this.itemOverTime = itemOverTime;
    }
}
