package com.wallet.Sevice;



import com.wallet.dto.Wallet;

import java.util.List;

public interface WalletService {
	
	Wallet getWalletById(Integer wid);
	
	Wallet createWallet(Wallet newWallet);
	
	Wallet updateWallet(Wallet newWallet);
	
	String deleteWallet (Integer deleteWid);
	
	List<Wallet> getAllWallet();
	
	

}
