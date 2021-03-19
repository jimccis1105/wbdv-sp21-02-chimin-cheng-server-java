package com.example.wbdvsp2102chiminchengserverjava.models;

public class Widget {
    private String name;
    private String type;
    private Integer widgetOrder;
    private String text;
    private String src;
    private Integer size;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;

    private Long id;
    private String topicIc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicIc() {
        return topicIc;
    }

    public void setTopicIc(String topicIc) {
        this.topicIc = topicIc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Widget(Long id, String topicIc, String type, Integer size, String text) {
        this.id = id;
        this.topicIc = topicIc;
        this.type = type;
        this.size = size;
        this.text = text;
    }

    public Widget() {
    }
}