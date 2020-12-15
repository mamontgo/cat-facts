package com.cats.boot.test;

import com.cats.model.FactsDto;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GetFactsIT extends EnvSettings {


    private FactsDto facts;

    @When("^the client calls for list \\/fact")
    public void clientCallsFactService() {
        this.facts = getTemplate().getForObject(getUrl() + "fact", FactsDto.class);
    }

    @Then("^the client facts returned have a count of (\\d+)")
    public void clientFactHasVoteCount(int count) {
        Assert.assertNotNull(facts);
        Assert.assertEquals(count, facts.getAll().size());
    }
}
