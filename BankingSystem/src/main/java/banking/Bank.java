package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
		// return null;
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		// return -1L;
		Long accountNumber = (long) accounts.values().size() + 1;
		CommercialAccount commercialAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, commercialAccount);
		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber = (long) accounts.values().size() + 1;
		ConsumerAccount consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, consumerAccount);
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		// return true;
		return getAccount(accountNumber).getPin() == pin;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return getAccount(accountNumber).debitAccount(amount);
	}
}
