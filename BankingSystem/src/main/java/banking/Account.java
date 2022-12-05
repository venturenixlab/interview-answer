package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account implements AccountInterface {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		// complete the constructor
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}

	@Override
	public AccountHolder getAccountHolder() {
		// complete the function
		// return null;
		return this.accountHolder;
	}

	@Override
	public boolean validatePin(int attemptedPin) {
		// complete the function
		return attemptedPin == this.pin;
	}

	@Override
	public double getBalance() {
		// complete the function
		return this.balance;
	}

	@Override
	public double getPin() {
		// complete the function
		return this.pin;
	}

	@Override
	public Long getAccountNumber() {
		// complete the function
		return this.accountNumber;
	}

	@Override
	public void creditAccount(double amount) {
		// complete the function
		// BigDecimal
		this.balance += amount; // bug, double + double
	}

	@Override
	public boolean debitAccount(double amount) {
		// complete the function
		if (amount > this.balance) {
			return false;
		}
		this.balance -= amount; // bug, double - double
		return true;
	}
}
