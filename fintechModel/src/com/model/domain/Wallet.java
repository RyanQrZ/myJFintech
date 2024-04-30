package com.model.domain;

import java.util.UUID;

import com.model.domain.enums.UserTypeEnum;
import com.model.domain.exceptions.BalanceException;
import com.model.domain.exceptions.TransferException;

/*
 *
 * This section is about wallet from user
 *
 */

public class Wallet {
	
	private UUID id = UUID.randomUUID();
	private double balance, balanceLimit;
	private User user;
	
	// Constructor receives who wallet belongs
	
	public Wallet(User user) {
		this.user = user;
	}
	
	// Adds credits to wallet
	
	public void addBalance(double value) {
		this.balance += value;
		this.balanceLimit = - (0.25 * this.balance);
	}
	
	// Transfer credits to another wallet 
	
	public void transferTo(Wallet fromWallet, double value, Wallet toWallet)
		{
		
		if(user.getType() == UserTypeEnum.SELLER) {
			// Exception, seller cannot transfer money
			throw new TransferException();
			
		}
		else {
			
			double newBalance  = this.balance - value;
			
			if(newBalance >= this.balanceLimit) {
				this.balance = newBalance;
				toWallet.addBalance(value);
				
			}
			else {
				// An exception occurred, insufficient balance
				throw new BalanceException();
				
			}
		}
	}
	
	// returns balance field
	
	public double getBalance() {
		return balance;
	}
	
	// returns balance limit
	
	public double getBalanceLimit() {
		return this.balanceLimit;
	}

}
