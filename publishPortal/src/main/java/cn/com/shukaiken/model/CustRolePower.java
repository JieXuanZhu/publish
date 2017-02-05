package cn.com.shukaiken.model;

import java.util.Date;

public class CustRolePower {
    private Integer id;

    private Integer cust_role_power_level;

    private String cust_role_power_name;

    private Date create_date;

    private Integer is_valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCust_role_power_level() {
        return cust_role_power_level;
    }

    public void setCust_role_power_level(Integer cust_role_power_level) {
        this.cust_role_power_level = cust_role_power_level;
    }

    public String getCust_role_power_name() {
        return cust_role_power_name;
    }

    public void setCust_role_power_name(String cust_role_power_name) {
        this.cust_role_power_name = cust_role_power_name == null ? null : cust_role_power_name.trim();
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(Integer is_valid) {
        this.is_valid = is_valid;
    }
}