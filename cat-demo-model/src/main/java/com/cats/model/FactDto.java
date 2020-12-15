package com.cats.model;

public class FactDto {
    private String id;

    private String text;

    private FactTypeDto type;

    private Long upvotes;

    private Boolean userUpvoted;

    private UserDto user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public FactTypeDto getType() {
        return type;
    }

    public void setType(FactTypeDto type) {
        this.type = type;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Long upvotes) {
        this.upvotes = upvotes;
    }

    public Boolean getUserUpvoted() {
        return userUpvoted;
    }

    public void setUserUpvoted(Boolean userUpvoted) {
        this.userUpvoted = userUpvoted;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
