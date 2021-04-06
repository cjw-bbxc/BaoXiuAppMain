package xyz.bbxc.estate.damain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auth: 白白小草
 * @Desc: 【业主】实体类(具体每个字段含义可以参考表中备注)
 * @DateTime: 2020/12/15 11:46
 */
@Table(name = "tb_owner")
public class Owner implements Serializable {
    private static final long serialVersionUID = 7173668903581907468L;

    @Id
    private Integer id;
    private Integer community_id;
    private Integer house_id;
    private String name;
    private String picture;
    private String id_card;
    private String telephone;
    private String profession;
    private String sex;
    private String type;
    private String remark;
    private String birthday;
    private String password;
    private Date create_time;
    private Date update_time;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Integer community_id) {
        this.community_id = community_id;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", community_id=" + community_id +
                ", house_id=" + house_id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", id_card='" + id_card + '\'' +
                ", telephone='" + telephone + '\'' +
                ", profession='" + profession + '\'' +
                ", sex='" + sex + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", birthday='" + birthday + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
