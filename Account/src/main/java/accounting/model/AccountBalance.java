package accounting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import accounting.Accounting;
import accounting.dao.MysqlHelper;
import accounting.exceptions.DataFetchError;
import accounting.exceptions.DataWriteError;
import accounting.exceptions.InsufficientBalanceException;
import accounting.exceptions.UserNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountBalance implements Accounting {
	private String accountID;
	private String balance;

	public AccountBalance() {

	}

	private AccountBalance(String accountID, String balance) {
		this.accountID = accountID;
		this.balance = balance;
	}

	public String getAccountID() {
		return accountID;
	}

	public String getBalance() {
		return balance;
	}

	public List<AccountBalance> getBalances(String userVector)
			throws UserNotFoundException, DataFetchError {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		List<AccountBalance> list = new ArrayList<AccountBalance>();
		try {
			con = MysqlHelper.getMysqlConnection("zeta_test", "zeta_test",
					"zeta_test");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" Connection cannot be Established");
			e.printStackTrace();
			return null;
		}

		if (con != null) {
			try {
				pst = con
						.prepareStatement("select account_id , balance from  accounts where user_id = (select user_id from users where phone_number ="
								+ userVector + " or email =" + userVector + ")");
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					list.add(new AccountBalance(rs.getString(1), rs
							.getString(2)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					con.close();
					pst.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				throw new DataFetchError();
			}
			try {
				if (con != null) {
					con.close();
				}
				if (pst != null) {
					pst.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}

		return null;
	}

	public AccountBalance debit(String userVector, Long accountID, int amount)
			throws UserNotFoundException, DataWriteError,
			InsufficientBalanceException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MysqlHelper.getMysqlConnection("zeta_test", "zeta_test",
					"zeta_test");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" Connection cannot be Established");
			e.printStackTrace();
			return null;
		}

		if (con != null) {
			try {
				pst = con
						.prepareStatement("select user_id from users where phone_number ="
								+ userVector + " or email =" + userVector);
				ResultSet rs = pst.executeQuery();
				if (!rs.isBeforeFirst()) {
					throw new UserNotFoundException();
				}
				pst = con
						.prepareStatement("select balance from accounts where account_id ="
								+ accountID
								+ " and user_id ="
								+ "(select user_id from users where phone_number ="
								+ userVector + " or email =" + userVector + ")");
				rs = pst.executeQuery();
				if (!rs.isBeforeFirst()) {
					throw new Exception("No account id found");
				}
				int balance = Integer.valueOf(rs.getString(1));
				if (balance < amount) {
					throw new InsufficientBalanceException();
				}
				int remaining_amount = balance - amount;

				try {
					pst = con.prepareStatement("update accounts set balance = "
							+ remaining_amount + " WHERE account_id = "
							+ accountID);
					rs = pst.executeQuery();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw new DataWriteError();
				}

			} catch (Exception e) {

			}
		}
		return null;
	}

	public AccountBalance credit(String userVector, Long accountID, int amount)
			throws UserNotFoundException, DataWriteError {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AccountOpeningClosingBalance> getOpeninglCosingBalances(
			String userVector, Date date) throws UserNotFoundException,
			DataWriteError {
		// TODO Auto-generated method stub
		return null;
	}
}
