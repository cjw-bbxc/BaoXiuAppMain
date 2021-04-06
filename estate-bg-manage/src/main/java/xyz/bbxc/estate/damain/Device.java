package xyz.bbxc.estate.damain;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.ws.BindingType;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auth: 白白小草
 * @Desc: 【设备】实体类(具体每个字段含义可以参考表中备注)
 * @DateTime: 2020/12/15 11:23
 */
@Table(name = "tb_device")
public class Device implements Serializable {
    private static final long serialVersionUID = 3503834050671872913L;
    @Id
    private Integer id;
    private String communityName;
    private Integer communityId;
    private String code;
    private String name;
    private String brand;
    private Integer unitPrice;
    private Integer num;
    private Integer expectedUsefulLife;
    private Date createTime;
    private Date updateTime;
    private Date purchaseDate;

    public Device() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getExpectedUsefulLife() {
        return expectedUsefulLife;
    }

    public void setExpectedUsefulLife(Integer expectedUsefulLife) {
        this.expectedUsefulLife = expectedUsefulLife;
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", communityId=" + communityId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", unitPrice=" + unitPrice +
                ", num=" + num +
                ", expectedUsefulLife=" + expectedUsefulLife +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
