package com.xdm.business.domain;

import com.xdm.common.core.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 流量池信息 poll
 *
 * @author xdm
 */
public class CardInfo extends BaseEntity {


    private String onlineStateInfo;

    private String stateChangeHistory;

    private String imeiInfo;

    private String apnInfo;

    private Card cardInfo;

    private List<OnlineStateInfo> onlineStateInfoList;

    private List<StateChangeHistory> stateChangeHistoryList;

    private List<ApnList> apnListList;

    private List<Imei> imeiList;

    public String getOnlineStateInfo() {
        return onlineStateInfo;
    }

    public void setOnlineStateInfo(String onlineStateInfo) {
        this.onlineStateInfo = onlineStateInfo;
    }

    public String getStateChangeHistory() {
        return stateChangeHistory;
    }

    public void setStateChangeHistory(String stateChangeHistory) {
        this.stateChangeHistory = stateChangeHistory;
    }

    public String getImeiInfo() {
        return imeiInfo;
    }

    public void setImeiInfo(String imeiInfo) {
        this.imeiInfo = imeiInfo;
    }

    public String getApnInfo() {
        return apnInfo;
    }

    public void setApnInfo(String apnInfo) {
        this.apnInfo = apnInfo;
    }

    public Card getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(Card cardInfo) {
        this.cardInfo = cardInfo;
    }

    public List<OnlineStateInfo> getOnlineStateInfoList() {
        return onlineStateInfoList;
    }

    public void setOnlineStateInfoList(List<OnlineStateInfo> onlineStateInfoList) {
        this.onlineStateInfoList = onlineStateInfoList;
    }

    public List<StateChangeHistory> getStateChangeHistoryList() {
        return stateChangeHistoryList;
    }

    public void setStateChangeHistoryList(List<StateChangeHistory> stateChangeHistoryList) {
        this.stateChangeHistoryList = stateChangeHistoryList;
    }

    public List<ApnList> getApnListList() {
        return apnListList;
    }

    public void setApnListList(List<ApnList> apnListList) {
        this.apnListList = apnListList;
    }

    public List<Imei> getImeiList() {
        return imeiList;
    }

    public void setImeiList(List<Imei> imeiList) {
        this.imeiList = imeiList;
    }
}
