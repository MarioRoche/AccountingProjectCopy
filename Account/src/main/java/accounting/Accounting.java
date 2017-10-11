package accounting;

import java.util.Date;
import java.util.List;

import accounting.exceptions.DataFetchError;
import accounting.exceptions.DataWriteError;
import accounting.exceptions.InsufficientBalanceException;
import accounting.exceptions.UserNotFoundException;
import accounting.model.AccountBalance;
import accounting.model.AccountOpeningClosingBalance;

public interface Accounting {
  /*
  * A user vector can be email or phone number.
  * Phone number can be line xxxxxxxxxx or 0xxxxxxxxxx or +91xxxxxxxxxx or 91xxxxxxxxxx.
  * Email will be like abc@pqr.com
  *
  * Returns AccountBalance for all accounts of that user.
  */
  public List<AccountBalance> getBalances(String userVector) throws UserNotFoundException, DataFetchError;

  /*
  * A user vector can be email or phone number.
  * Phone number can be line xxxxxxxxxx or 0xxxxxxxxxx or +91xxxxxxxxxx or 91xxxxxxxxxx.
  * Email will be like abc@pqr.com
  *
  * Amount is self explanatory.
  *
  * Ensure that account belongs to this user.
  * Verifies that debit can be done or not.
  * Makes a debit Posting on this account for given amount.
  * Update balance for this account.
  *
  */
  public AccountBalance debit(String userVector, Long accountID, int amount)
    throws UserNotFoundException, DataWriteError, InsufficientBalanceException;

  /*
  * A user vector can be email or phone number.
  * Phone number can be line xxxxxxxxxx or 0xxxxxxxxxx or +91xxxxxxxxxx or 91xxxxxxxxxx.
  * Email will be like abc@pqr.com
  *
  * Amount is self explanatory.
  *
  * Ensure that account belongs to this user.
  * Makes a credit Posting on this account for given amount.
  * Update balance for this account.
  *
  */
  public AccountBalance credit(String userVector, Long accountID, int amount)
    throws UserNotFoundException, DataWriteError;

  /*
  * A user vector can be email or phone number.
  * Phone number can be line xxxxxxxxxx or 0xxxxxxxxxx or +91xxxxxxxxxx or 91xxxxxxxxxx.
  * Email will be like abc@pqr.com
  *
  * date is the day for which opening closing balances are needed.
  *
  * Return opening and closing balances for all accounts of this user on given date.
  *
  */

  public List<AccountOpeningClosingBalance> getOpeninglCosingBalances(String userVector, Date date)
    throws UserNotFoundException, DataWriteError;
}
