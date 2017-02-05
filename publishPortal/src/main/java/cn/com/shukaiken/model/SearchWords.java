package cn.com.shukaiken.model;

import java.util.Date;

public class SearchWords {
    private Integer id;

    private String name;

    private Integer hit_count;

    private Integer priority;

    private String name_initial;

    private Date create_date;

    private Integer is_valid;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getHit_count() {
        return hit_count;
    }

    public void setHit_count(Integer hit_count) {
        this.hit_count = hit_count;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getName_initial() {
        return name_initial;
    }

    public void setName_initial(String name_initial) {
        this.name_initial = name_initial == null ? null : name_initial.trim();
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