package com.wallet.Contoller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.Sevice.WalletService;
import com.wallet.dto.Wallet;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {WalletController.class})
@ExtendWith(SpringExtension.class)
class WalletControllerTest {
    @Autowired
    private WalletController walletController;

    @MockBean
    private WalletService walletService;

    /**
     * Method under test: {@link WalletController#addWallet(Wallet)}
     */
    @Test
    void testAddWallet() throws Exception {
        Wallet wallet = new Wallet();
        wallet.setBalance(10.0d);
        wallet.setId(1);
        wallet.setName("Name");
        when(walletService.createWallet((Wallet) any())).thenReturn(wallet);

        Wallet wallet1 = new Wallet();
        wallet1.setBalance(10.0d);
        wallet1.setId(1);
        wallet1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(wallet1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(walletController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\",\"balance\":10.0}"));
    }

    /**
     * Method under test: {@link WalletController#deleteWalletById(Integer)}
     */
    @Test
    void testDeleteWalletById() throws Exception {
        when(walletService.deleteWallet((Integer) any())).thenReturn("Delete Wallet");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/wallet/{wid}", 1);
        MockMvcBuilders.standaloneSetup(walletController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Wallet"));
    }

    /**
     * Method under test: {@link WalletController#deleteWalletById(Integer)}
     */
    @Test
    void testDeleteWalletById2() throws Exception {
        when(walletService.deleteWallet((Integer) any())).thenReturn("Delete Wallet");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/wallet/{wid}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(walletController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Wallet"));
    }

    /**
     * Method under test: {@link WalletController#findAllWallets()}
     */
    @Test
    void testFindAllWallets() throws Exception {
        when(walletService.getAllWallet()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/wallets");
        MockMvcBuilders.standaloneSetup(walletController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

