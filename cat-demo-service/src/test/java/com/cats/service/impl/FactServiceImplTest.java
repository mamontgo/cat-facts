package com.cats.service.impl;

import com.cats.data.builder.FactBuilder;
import com.cats.data.builder.UserBuilder;
import com.cats.data.entity.Fact;
import com.cats.data.entity.FactType;
import com.cats.data.repository.FactRepository;
import com.cats.model.FactDto;
import com.cats.model.FactTypeDto;
import com.cats.model.FactsDto;
import com.cats.service.FactService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FactServiceImpl.class})
public class FactServiceImplTest {

    private static final String UUID = "UUID";

    @Autowired
    private FactService service;

    @MockBean
    private FactRepository repository;

    @Test
    public void findById() {
        Fact fact = FactBuilder.of()
                .withFactType(FactType.cat)
                .withText("text")
                .withId("id")
                .withUser(
                        UserBuilder.of("uid", "first", "last")
                )
                .withVotes(10L)
                .withUserUpvoted(false)
                .build();
        Mockito.when(repository.getOne(UUID)).thenReturn(fact);
        FactDto result = service.findById(UUID);
        Assert.assertEquals(FactTypeDto.cat, result.getType());
        Assert.assertEquals("text", result.getText());
        Assert.assertEquals("id", result.getId());
        Assert.assertEquals("uid", result.getUser().getId());
        Assert.assertEquals("first", result.getUser().getFirst());
        Assert.assertEquals("last", result.getUser().getLast());
        Assert.assertEquals(10L, result.getUpvotes().longValue());
        Assert.assertFalse(result.getUserUpvoted());

    }

    @Test
    public void findByIdNull() {

        Mockito.when(repository.getOne(UUID)).thenReturn(null);
        FactDto result = service.findById(UUID);
        Assert.assertNull(result);
    }

    @Test
    public void findAll() {
        List<Fact> facts = build();
        Mockito.when(repository.findAll()).thenReturn(facts);
        List<FactDto> result = service.findAll();
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("one", result.get(0).getId());
        Assert.assertEquals("one", result.get(0).getText());
        Assert.assertEquals(FactTypeDto.cat, result.get(0).getType());
        Assert.assertEquals("two", result.get(1).getId());
        Assert.assertEquals("two", result.get(1).getText());
        Assert.assertEquals(FactTypeDto.dog, result.get(1).getType());
    }

    @Test
    public void findAllCatFacts() {
        Mockito.when(repository.findAll()).thenReturn(build());
        FactsDto result = service.findAllFacts();
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.getAll().size());
    }


    private List<Fact> build() {

        return Arrays.asList(
                FactBuilder.of()
                        .withFactType(FactType.cat)
                        .withText("one")
                        .withId("one")
                        .build()
                ,
                FactBuilder.of()
                        .withFactType(FactType.dog)
                        .withText("two")
                        .withId("two")
                        .build()
        );
    }
}
