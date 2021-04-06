package xyz.bbxc.estate.damain;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.ws.BindingType;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auth: 白白小草
 * @Desc: 【收费名细】实体类(具体每个字段含义可以参考表中备注)
 * @DateTime: 2020/12/15 11:11
 */
@Table(name="tb_charge_detail")
public class ChargeDetail implements Serializable {
    private static final long serialVersionUID = -6473919388891792548L;
    @Id
    private Integer id;
    private Integer communityId;
    private String communityName;
    private Integer chargeItemId;
    private String chargeItemName;
    private String contractor;
    private Integer telephone;
    private Integer payMoney;
    private Integer actualMoney;
    private Date createTime;
    private Date updateTime;
    private Date payTime;
    private String status;

    public ChargeDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(Integer chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public String getChargeItemName() {
        return chargeItemName;
    }

    public void setChargeItemName(String chargeItemName) {
        this.chargeItemName = chargeItemName;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Integer actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ChargeDetail{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", chargeItemId=" + chargeItemId +
                ", chargeItemName='" + chargeItemName + '\'' +
                ", contractor='" + contractor + '\'' +
                ", telephone=" + telephone +
                ", payMoney=" + payMoney +
                ", actualMoney=" + actualMoney +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", payTime=" + payTime +
                ", status='" + status + '\'' +
                '}';
    }
}
