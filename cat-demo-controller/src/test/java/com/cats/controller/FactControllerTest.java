package com.cats.controller;

import com.cats.model.FactDto;
import com.cats.model.FactsDto;
import com.cats.service.FactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FactController.class)
@ContextConfiguration(classes = FactController.class)
public class FactControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private FactController controller;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FactService factService;

    @Test
    public void getById() throws Exception {
        FactDto mock = new FactDto();
        mock.setText("Hello");

        Mockito.when(factService.findById("uuid")).thenReturn(mock);


        ResultActions resultActions = this.mockMvc.perform(get("/fact/uuid"))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        FactDto response = objectMapper.readValue(contentAsString, FactDto.class);
        Assert.assertEquals(mock.getText(), response.getText());

    }

    @Test
    public void getAll() throws Exception {
        FactsDto mock = new FactsDto();
        mock.setAll(
                Arrays.asList(new FactDto(), new FactDto())
        );
        mock.getAll().get(0).setText("Hello There");

        Mockito.when(factService.findAllFacts()).thenReturn(mock);


        ResultActions resultActions = this.mockMvc.perform(get("/fact"))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        FactsDto response = objectMapper.readValue(contentAsString, FactsDto.class);
        Assert.assertEquals(2, response.getAll().size());
        Assert.assertEquals("Hello There", response.getAll().get(0).getText());

    }

}
