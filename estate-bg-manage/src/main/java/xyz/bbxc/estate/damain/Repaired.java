package xyz.bbxc.estate.damain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Classname Repaired
 * @Description TODO
 * @Date 2021-4-3 16:02
 * @Created by 白白小草
 */
@Table(name = "tb_repaired")
public class Repaired {
    @Id
    private Integer id;
    private String name;
    private String address;
    private String telephone;
    private String type;
    private String description;
    private String picture;
    private String status;
    private String create_time;
    private String repairManName;
    private String repairpicture;

    @Override
    public String toString() {
        return "Repaired{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", status='" + status + '\'' +
                ", create_time='" + create_time + '\'' +
                ", repairManName='" + repairManName + '\'' +
                ", repairpicture='" + repairpicture + '\'' +
                '}';
    }

    public String getRepairpicture() {
        return repairpicture;
    }

    public void setRepairpicture(String repairpicture) {
        this.repairpicture = repairpicture;
    }

    public String getRepairManName() {
        return repairManName;
    }

    public void setRepairManName(String repairManName) {
        this.repairManName = repairManName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

}
