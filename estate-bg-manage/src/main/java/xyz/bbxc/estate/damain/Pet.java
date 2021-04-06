package xyz.bbxc.estate.damain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auth: 白白小草
 * @Desc: 【宠物】实体类(具体每个字段含义可以参考表中备注)
 * @DateTime: 2020/12/15 11:57
 */
@Table(name = "tb_pet")
public class Pet implements Serializable {
    private static final long serialVersionUID = 8280965343727820463L;
    @Id
    private Integer id;
    private String picture;
    private String ownerName;
    private Integer ownerId;
    private String name;
    private String color;
    private String remark;
    private Date createTime;
    private Date updateTime;
    private Date adoptTime;

    public Pet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(Date adoptTime) {
        this.adoptTime = adoptTime;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", adoptTime=" + adoptTime +
                '}';
    }
}
