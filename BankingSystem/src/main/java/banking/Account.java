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
public abstract class Account {
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

	public AccountHolder getAccountHolder() {
		// complete the function
		// return null;
		return this.accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
		// complete the function
		// return true;
		return attemptedPin == this.pin;
	}

	public double getBalance() {
		// complete the function
		// return -1;
		return this.balance;
	}

	public double getPin() {
		// complete the function
		// return -1;
		return this.pin;
	}

	public Long getAccountNumber() {
		// complete the function
		// return -1L;
		return this.accountNumber;
	}

	public void creditAccount(double amount) {
		// complete the function
		// this.balance =
		// BigDecimal.valueOf(balance).add(BigDecimal.valueOf(amount)).doubleValue();
		this.balance += amount;
	}

	public boolean debitAccount(double amount) {
		// complete the function
		// return true;
		if (amount > this.balance) {
			return false;
		}
		// this.balance =
		// BigDecimal.valueOf(balance).subtract(BigDecimal.valueOf(amount)).doubleValue();
		this.balance -= amount;
		return true;
	}
}
