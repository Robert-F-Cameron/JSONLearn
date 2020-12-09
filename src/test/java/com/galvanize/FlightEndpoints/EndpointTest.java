package com.galvanize.FlightEndpoints;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasEntry;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;


@WebMvcTest(Endpoints.class)
public class EndpointTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getFlight() throws Exception{
        this.mvc.perform(
                get("/flights/flight")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].departsOn", is("2020-12-31 10:02")))
                .andExpect(jsonPath("$[0].tickets[0].firstName", is("Robert")))
                .andExpect(jsonPath("$[0].price", is(200)));
    }
    @Test
    public void getFlights() throws Exception{
        this.mvc.perform(
                get("/flights")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].departsOn", is("2020-12-31 10:02")))
                .andExpect(jsonPath("$[0].tickets[0].firstName", is("Robert")))
                .andExpect(jsonPath("$[0].tickets[0].lastName", is("Cameron")))
                .andExpect(jsonPath("$[0].tickets[1].firstName", is("Alden")))
                .andExpect(jsonPath("$[0].tickets[1].lastName", is("Davidson")))
                .andExpect(jsonPath("$[0].price", is(200)))
                .andExpect(jsonPath("$[1].departsOn", is("2020-12-25 10:02")))
                .andExpect(jsonPath("$[1].tickets[0].firstName", is("Robert")))
                .andExpect(jsonPath("$[1].tickets[0].lastName", is("Cameron")))
                .andExpect(jsonPath("$[1].tickets[1].firstName", is("Alden")))
                .andExpect(jsonPath("$[1].tickets[1].lastName", is("Davidson")))
                .andExpect(jsonPath("$[1].price", is(200)));
    }
}
