package xyz.bbxc.estate.damain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 小区实体类
 */
@Table(name = "tb_community")
public class Community implements Serializable {

    @Id
    private Integer id;
    @Column
    private String code;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Double area;
    @Column
    private Integer total_buildings;
    @Column
    private Integer total_households;
    @Column
    private Integer greening_rate;
    @Column
    private String thumbnail;
    @Column
    private String developer;
    @Column
    private String estate_company;
    @Column
    private Date create_time;
    @Column
    private Date update_time;
    @Column
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getTotal_buildings() {
        return total_buildings;
    }

    public void setTotal_buildings(Integer total_buildings) {
        this.total_buildings = total_buildings;
    }

    public Integer getTotal_households() {
        return total_households;
    }

    public void setTotal_households(Integer total_households) {
        this.total_households = total_households;
    }

    public Integer getGreening_rate() {
        return greening_rate;
    }

    public void setGreening_rate(Integer greening_rate) {
        this.greening_rate = greening_rate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getEstate_company() {
        return estate_company;
    }

    public void setEstate_company(String estate_company) {
        this.estate_company = estate_company;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", total_buildings=" + total_buildings +
                ", total_households=" + total_households +
                ", greening_rate=" + greening_rate +
                ", thumbnail='" + thumbnail + '\'' +
                ", developer='" + developer + '\'' +
                ", estate_company='" + estate_company + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", status='" + status + '\'' +
                '}';
    }
}
