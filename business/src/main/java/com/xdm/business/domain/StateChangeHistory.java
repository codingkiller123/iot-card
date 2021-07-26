package com.xdm.business.domain;

public class StateChangeHistory {

    /**
     *源状态(1：待激活;2：已激活;4：停机;6：可测试;7：库存;8：预销户;9：已销户)
     */
    private String descStatus;

    /**
     *目标状态(1：待激活;2：已激活;4：停机;6：可测试;7：库存;8：预销户;9：已销户)
     */
    private String targetStatus;

    /**
     *变更时间
     */
    private String changeDate;

    public String getDescStatus() {
        return descStatus;
    }

    public void setDescStatus(String descStatus) {
        this.descStatus = descStatus;
    }

    public String getTargetStatus() {
        return targetStatus;
    }

    public void setTargetStatus(String targetStatus) {
        this.targetStatus = targetStatus;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }
}
