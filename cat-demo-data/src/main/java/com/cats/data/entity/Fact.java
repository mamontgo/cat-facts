package com.cats.data.entity;

import javax.persistence.*;

@Entity
public class Fact {

    @Id
    private String id;

    private String text;

    @Enumerated(EnumType.STRING)
    private FactType type;

    private Long upvotes;

    private Boolean userUpvoted;

    @ManyToOne
    private User user;

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

    public FactType getType() {
        return type;
    }

    public void setType(FactType type) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
