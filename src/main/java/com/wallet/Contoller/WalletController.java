package com.wallet.Contoller;

import com.wallet.Sevice.WalletService;
import com.wallet.dto.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class WalletController {

	@Autowired
private WalletService walletService;

@PostMapping("wallet")
public Wallet addWallet(@RequestBody Wallet newWallet) {
return this.walletService.createWallet(newWallet);

}

@GetMapping("wallet/{wid}")
public Wallet findWalletById(@PathVariable("wid") Integer walletId) {
	return this.walletService.getWalletById(walletId);
}

@PutMapping("wallet/{wid}")
public Wallet updateWallet(@RequestBody Wallet wallet) {
	return this.walletService.updateWallet(wallet);

}

@DeleteMapping("wallet/{wid}")
public String deleteWalletById(@PathVariable Integer wid) {

	return this.walletService.deleteWallet(wid);
}

@GetMapping("wallets")
public List<Wallet> findAllWallets(){

	return this.walletService.getAllWallet();
	}
}
