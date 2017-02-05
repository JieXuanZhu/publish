package cn.com.shukaiken.model;

import java.util.Date;

public class SensitiveWords {
    private Integer id;

    private String words;
    
    private String special_character;

    private Date create_date;

    private Integer is_valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words == null ? null : words.trim();
    }
    
    public String getSpecial_character() {
		return special_character;
	}

	public void setSpecial_character(String special_character) {
		this.special_character = special_character == null ? null : special_character.trim();;
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