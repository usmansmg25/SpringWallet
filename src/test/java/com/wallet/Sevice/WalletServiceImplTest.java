package com.wallet.Sevice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.wallet.Repo.WalletRepository;
import com.wallet.dto.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WalletServiceImpl.class})
@ExtendWith(SpringExtension.class)
class WalletServiceImplTest {
    @MockBean
    private WalletRepository walletRepository;

    @Autowired
    private WalletServiceImpl walletServiceImpl;

    /**
     * Method under test: {@link WalletServiceImpl#getWalletById(Integer)}
     */
    @Test
    void testGetWalletById() {
        Wallet wallet = new Wallet();
        wallet.setBalance(10.0d);
        wallet.setId(1);
        wallet.setName("Name");
        Optional<Wallet> ofResult = Optional.of(wallet);
        when(walletRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(wallet, walletServiceImpl.getWalletById(1));
        verify(walletRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link WalletServiceImpl#getWalletById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWalletById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.wallet.Sevice.WalletServiceImpl.getWalletById(WalletServiceImpl.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        when(walletRepository.findById((Integer) any())).thenReturn(Optional.empty());
        walletServiceImpl.getWalletById(1);
    }

    /**
     * Method under test: {@link WalletServiceImpl#createWallet(Wallet)}
     */
    @Test
    void testCreateWallet() {
        Wallet wallet = new Wallet();
        wallet.setBalance(10.0d);
        wallet.setId(1);
        wallet.setName("Name");
        when(walletRepository.save((Wallet) any())).thenReturn(wallet);

        Wallet wallet1 = new Wallet();
        wallet1.setBalance(10.0d);
        wallet1.setId(1);
        wallet1.setName("Name");
        assertSame(wallet, walletServiceImpl.createWallet(wallet1));
        verify(walletRepository).save((Wallet) any());
    }

    /**
     * Method under test: {@link WalletServiceImpl#updateWallet(Wallet)}
     */
    @Test
    void testUpdateWallet() {
        Wallet wallet = new Wallet();
        wallet.setBalance(10.0d);
        wallet.setId(1);
        wallet.setName("Name");
        when(walletRepository.save((Wallet) any())).thenReturn(wallet);

        Wallet wallet1 = new Wallet();
        wallet1.setBalance(10.0d);
        wallet1.setId(1);
        wallet1.setName("Name");
        assertSame(wallet, walletServiceImpl.updateWallet(wallet1));
        verify(walletRepository).save((Wallet) any());
    }

    /**
     * Method under test: {@link WalletServiceImpl#deleteWallet(Integer)}
     */
    @Test
    void testDeleteWallet() {
        doNothing().when(walletRepository).deleteById((Integer) any());
        assertEquals("Wallet deleted", walletServiceImpl.deleteWallet(1));
        verify(walletRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link WalletServiceImpl#getAllWallet()}
     */
    @Test
    void testGetAllWallet() {
        ArrayList<Wallet> walletList = new ArrayList<>();
        when(walletRepository.findAll()).thenReturn(walletList);
        List<Wallet> actualAllWallet = walletServiceImpl.getAllWallet();
        assertSame(walletList, actualAllWallet);
        assertTrue(actualAllWallet.isEmpty());
        verify(walletRepository).findAll();
    }
}

