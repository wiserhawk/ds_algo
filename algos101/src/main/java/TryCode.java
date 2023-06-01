import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TryCode {
	
	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
	
	public Set<BigDecimal> getFinalTransactions(Set<BigDecimal> allCashflowTransactions, BigDecimal totalMarketValue, BigDecimal percentage) {
		return getCashFlowTransactionByFilter(allCashflowTransactions,
                cash -> cash.abs().compareTo(percentage(totalMarketValue, percentage)) >= 0);
	}
	
	private Set<BigDecimal> getCashFlowTransactionByFilter(Set<BigDecimal> cashFlowTransaction, Predicate<BigDecimal> predicate) {
        return cashFlowTransaction
                .stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }
	
	public static BigDecimal percentage(BigDecimal base, BigDecimal pct) {
        return base.multiply(pct).divide(ONE_HUNDRED);
    }
	
	
	public static void main(String[] args) {
		BigDecimal totalMarketValue = new BigDecimal(107670072.62);
		BigDecimal percentage = new BigDecimal(10.0000); 
		
		Set<BigDecimal> allCashflowTransactions = new HashSet<>();
		allCashflowTransactions.add(new BigDecimal(-70000000));
		allCashflowTransactions.add(new BigDecimal(-42000000));
		allCashflowTransactions.add(new BigDecimal(50000000));
		allCashflowTransactions.add(new BigDecimal(-17149.21));
		allCashflowTransactions.add(new BigDecimal(-55000000));
		allCashflowTransactions.add(new BigDecimal(-20480.75));
		allCashflowTransactions.add(new BigDecimal(-57699.34));
		allCashflowTransactions.add(new BigDecimal(-14066.68));
		
		TryCode tryCode = new TryCode();
		Set<BigDecimal> finalTransactions = tryCode.getFinalTransactions(allCashflowTransactions, totalMarketValue, percentage);
		
		System.out.println("======FINAL TRANSACTIONS======");
		for(BigDecimal txt : finalTransactions) {
			System.out.println(txt.toString());
		}
		
		testit();
		
	}
	
//	public class Outer {
//		List<Account> accounts;
//		
//		public Outer(List<Account> accounts) {
//			this.accounts = accounts;
//		}
//		
//		public List<Account> getAccounts() {
//			return this.accounts;
//		}
//	}
//	
//	public class Account {
//		int id;
//		String name;
//		boolean isNew;
//		
//		public Account(int id, String name, boolean isNew) {
//			this.id = id;
//			this.name = name;
//			this.isNew = isNew;
//		}
//	}
//	
//	private static void testit() {
//		
//		TryCode x = new TryCode();
//		
//		List<Account> accounts = new ArrayList<>();
//		accounts.add(x.new Account(1, "First", false));
//		accounts.add(x.new Account(2, "Second", false));
//		accounts.add(x.new Account(3, "Third", false));
//		
//		Outer outer = x.new Outer(accounts);
//		
//		outer.getAccounts().stream().forEach(acc -> acc.isNew = true);
//		
//		for (Account a : outer.getAccounts())
//			System.out.println(a.id + "-" + a.name + "-" + a.isNew);
//	}
	

}
