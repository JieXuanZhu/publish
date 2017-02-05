package cn.com.shukaiken.model;

import java.util.Date;

public class CustSurplusCount {
    private Integer id;

    private Integer cust_id;

    private Integer surplus_user_count;

    private Integer surplus_admin_count;

    private Date edit_date;

    private Integer is_valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public Integer getSurplus_user_count() {
        return surplus_user_count;
    }

    public void setSurplus_user_count(Integer surplus_user_count) {
        this.surplus_user_count = surplus_user_count;
    }

    public Integer getSurplus_admin_count() {
        return surplus_admin_count;
    }

    public void setSurplus_admin_count(Integer surplus_admin_count) {
        this.surplus_admin_count = surplus_admin_count;
    }

    public Date getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(Date edit_date) {
        this.edit_date = edit_date;
    }

    public Integer getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(Integer is_valid) {
        this.is_valid = is_valid;
    }
}