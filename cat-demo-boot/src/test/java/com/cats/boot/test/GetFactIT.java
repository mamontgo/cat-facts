package com.cats.boot.test;

import com.cats.model.FactDto;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GetFactIT extends ApplicationBaseIT {

    private FactDto fact;

    @When("^the client calls \\/fact with id (.+)$")
    public void clientCallsFactService(String string1) {
        this.fact = getTemplate().getForObject(getUrl() + "fact/" + string1, FactDto.class);
    }


    @Then("^the client fact has fact type (.+)")
    public void clientFactHasFactType(String type) {
        Assert.assertNotNull(fact);
        Assert.assertEquals(type, fact.getType().name());
    }

    @Then("^the client fact has user first name (.+)")
    public void clientFactHasUserFirstName(String name) {
        Assert.assertNotNull(fact);
        Assert.assertEquals(name, fact.getUser().getFirst());
    }

    @Then("^the client fact has user last name (.+)")
    public void clientFactHasUserLastName(String name) {
        Assert.assertNotNull(fact);
        Assert.assertEquals(name, fact.getUser().getLast());

    }

    @Then("^the client fact has a vote count of (\\d+)")
    public void clientFactHasVoteCount(long votes) {
        Assert.assertNotNull(fact);
        Assert.assertEquals(votes, fact.getUpvotes().longValue());

    }
}
