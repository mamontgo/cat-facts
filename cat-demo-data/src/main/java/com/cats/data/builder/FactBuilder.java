package com.cats.data.builder;

import com.cats.data.entity.Fact;
import com.cats.data.entity.FactType;
import com.cats.data.entity.User;

public class FactBuilder {

    private Fact fact;

    public FactBuilder() {
        this.fact = new Fact();
    }

    public FactBuilder withText(String text) {
        this.fact.setText(text);
        return this;
    }

    public FactBuilder withId(String uuid) {
        this.fact.setId(uuid);
        return this;
    }


    public FactBuilder withUser(User user) {
        this.fact.setUser(user);
        return this;
    }

    public FactBuilder withFactType(FactType type) {
        this.fact.setType(type);
        return this;
    }

    public FactBuilder withVotes(Long votes) {
        this.fact.setUpvotes(votes);
        return this;
    }

    public FactBuilder withUserUpvoted(Boolean upvoted) {
        this.fact.setUserUpvoted(upvoted);
        return this;
    }

    public Fact build() {
        return this.fact;
    }

    public static FactBuilder of() {
        return new FactBuilder();
    }

}
