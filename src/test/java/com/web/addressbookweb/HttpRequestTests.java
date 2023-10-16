package com.web.addressbookweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.addressbookweb.addressBook.AddressBookAddBuddyResource;
import com.web.addressbookweb.addressBook.AddressBookRequestResource;
import com.web.addressbookweb.buddyInfo.BuddyInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class HttpRequestTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final String uri = "/api/v1/addressBook";

    @Test
    public void shouldReturnAListOfAddressBooks() throws Exception {
        this.mockMvc.perform(get(uri))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldCreateAnAddressBook() throws Exception {
        AddressBookRequestResource arr  = new AddressBookRequestResource(5L, List.of(
                new BuddyInfo("Geo", "1123A",  "009", 9L)
        ));

        String requestBody = objectMapper.writeValueAsString(arr);

        mockMvc.perform(post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteBuddyInfoWithIdOneInAddressBookWithIdOne() throws Exception {
        this.mockMvc.perform(delete(uri + "/2/3"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteAddressBookWithIdOne() throws Exception {
        this.mockMvc.perform(delete(uri + "/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldAddABuddyToAddressBookWithIdTwo() throws Exception  {
        AddressBookAddBuddyResource abr = new AddressBookAddBuddyResource(2L,
                new BuddyInfo("Mark", "134 ShoeAve", "123-998-666", 6L));

        String requestBody = objectMapper.writeValueAsString(abr);

        mockMvc.perform(patch(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
