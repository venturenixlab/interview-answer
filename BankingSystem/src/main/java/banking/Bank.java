package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts; // object reference

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>(); // memory
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return this.accounts.get(accountNumber);
	}

	@Override
	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		// return -1L;
		Long newAccountId = (long) accounts.size() + 1;
		CommercialAccount commercialAccount = new CommercialAccount(company, newAccountId, pin, startingDeposit);
		accounts.put(newAccountId, commercialAccount);
		return newAccountId;
	}

	@Override
	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Long newAccountId = (long) accounts.size() + 1;
		ConsumerAccount consumerAccount = new ConsumerAccount(person, newAccountId, pin, startingDeposit);
		accounts.put(newAccountId, consumerAccount);
		return newAccountId;
	}

	@Override
	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		// return true;
		return this.getAccount(accountNumber).validatePin(pin);
	}

	@Override
	public double getBalance(Long accountNumber) {
		// complete the function
		return this.getAccount(accountNumber).getBalance();
	}

	@Override
	public void credit(Long accountNumber, double amount) {
		// complete the function
		this.getAccount(accountNumber).creditAccount(amount);
	}

	@Override
	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return this.getAccount(accountNumber).debitAccount(amount);
	}
}
