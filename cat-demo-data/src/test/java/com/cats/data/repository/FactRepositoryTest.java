package com.cats.data.repository;

import com.cats.data.builder.FactBuilder;
import com.cats.data.builder.UserBuilder;
import com.cats.data.entity.Fact;
import com.cats.data.entity.FactType;
import com.cats.data.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {FactRepository.class, UserRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = "com.cats.data.entity")
@EnableJpaRepositories(basePackages = "com.cats.data.repository")
public class FactRepositoryTest {


    private long INITIAL_FACTS = 45L;
    private long INITIAL_USERS = 7L;

    @Autowired
    private FactRepository repository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Crude test
     * count the records inserted by liquibase scripts
     * and add additional records and count
     */
    @Test
    public void addNewCatFact() {

        Assert.assertEquals(INITIAL_FACTS, repository.count());
        Assert.assertEquals(INITIAL_USERS, userRepository.count());

        User user = userRepository.save(UserBuilder.of("Hello", "World"));

        String factUuid = UUID.randomUUID().toString();

        repository.save(FactBuilder.of()
                .withId(factUuid)
                .withUser(user)
                .withText("Cats are funny")
                .withVotes(10L)
                .withFactType(FactType.cat).build()
        );

        Fact fact = repository.getOne(factUuid);

        Assert.assertNotNull(fact);
        Assert.assertEquals("Cats are funny", fact.getText());
        Assert.assertEquals(FactType.cat, fact.getType());
        Assert.assertEquals("Hello", fact.getUser().getFirst());
        Assert.assertEquals("World", fact.getUser().getLast());

        Assert.assertEquals(INITIAL_FACTS + 1, repository.count());

        repository.save(FactBuilder.of()
                .withId(UUID.randomUUID().toString())
                .withUser(user)
                .withText("Cats are lazy")
                .withVotes(100L)
                .withFactType(FactType.cat).build()
        );

        Assert.assertEquals(INITIAL_FACTS + 2, repository.count());

    }


}
