package com.example.model;

// import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Calendar;

// import javax.validation.constraints.Pattern;


public class Message {

    private Long id;

    @NotEmpty(message = "Text is required.")
    //@Pattern(regexp="\\d+")
    private String text;

    @NotEmpty(message = "Summary is required.")
    //@Range(min = 0, max = 10)
    @Size(min = 5, max = 30, message = "Summary内容长度需要在{min}-{max}之间")
    private String summary;

    private Calendar created = Calendar.getInstance();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreated() {
        return this.created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
