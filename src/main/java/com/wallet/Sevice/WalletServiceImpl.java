package com.wallet.Sevice;


import com.wallet.Repo.WalletRepository;
import com.wallet.dto.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class WalletServiceImpl implements WalletService{

@Autowired
private WalletRepository walletRepo;

@Override
public Wallet getWalletById(Integer wid) {
	Optional<Wallet> optWallet = this.walletRepo.findById(wid);
	
		return optWallet.get();
	}

	@Override
	public Wallet createWallet(Wallet newWallet) {
		return this.walletRepo.save(newWallet);
	
	}

	@Override
	public Wallet updateWallet(Wallet Wallet) {
	
		return this.walletRepo.save(Wallet);
	}

	@Override
	public String deleteWallet(Integer deleteWid) {
		this.walletRepo.deleteById(deleteWid);
		return "Wallet deleted";
	}

	@Override
	public List<Wallet> getAllWallet() {

		return this.walletRepo.findAll();
	}

}
