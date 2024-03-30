package com.userPayment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userPayment.adapter.in.web.PostUserRegisterRequest;
import com.userPayment.adapter.in.web.PutUserRegisterRequest;
import com.userPayment.adapter.out.persistence.UserEntity;
import com.userPayment.adapter.out.persistence.UserInfoPersistenceAdapter;
import com.userPayment.application.port.in.UserEditUseCase;
import com.userPayment.domain.UserInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserInfoPersistenceAdapter userInfoPersistenceAdapter;

    @Autowired
    private UserEditUseCase userEditUseCase;

    private MockData mockData;

    @Test
    @DisplayName("Success User Post Test")
    public void successPostTest() throws Exception {

        PostUserRegisterRequest newRequest = new PostUserRegisterRequest(
                "new name", "new address", "new email", false
        );

        UserInfo newUser = UserInfo.generateUser(
                new UserInfo.UserId(1L),
                new UserInfo.UserName("new name"),
                new UserInfo.UserEmail("new address"),
                new UserInfo.UserAddress("new email"),
                new UserInfo.UserIsValidUser(true),
                new UserInfo.UserIsIndividualCompany(false)
        );

        mockMvc.perform(post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newRequest))
                )
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(newUser)));
    }

    @Test
    @DisplayName("Fail User Get Test")
    public void successGetTest() throws Exception{

        mockMvc.perform(get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());

    }

    @Test
    @DisplayName("Success User edit test")
    public void successEditTest() throws Exception {

//        UserEntity newUser = new UserEntity(1L, "edited new name", "edited new address", "new email", true, false);




        PutUserRegisterRequest newRequest = new PutUserRegisterRequest(
                1L, "edited new name", "edited new address", "new email", false
        );

        UserInfo newUser = UserInfo.generateUser(
                new UserInfo.UserId(1L),
                new UserInfo.UserName("edited new name"),
                new UserInfo.UserEmail("edited new address"),
                new UserInfo.UserAddress("new email"),
                new UserInfo.UserIsValidUser(true),
                new UserInfo.UserIsIndividualCompany(false)
        );

        mockMvc.perform(put("/user/modify/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newRequest))
                )
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(newUser)));
    }
}
