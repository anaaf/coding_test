package com.smallworld;

import com.smallworld.DataStore.DataStore;
import com.smallworld.DataStore.IDataStore;
import com.smallworld.Model.Transaction;
import com.smallworld.Repositories.Transaction.ITransactionRespository;
import com.smallworld.Repositories.Transaction.TransactionRespository;
import com.smallworld.Services.ITransactionService;
import com.smallworld.Services.TransactionService;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TransactionDataFetcher {

    private ITransactionService TransactionService;
    public TransactionDataFetcher() {
        Dotenv dotenv = Dotenv.load();
        IDataStore ds = new DataStore(dotenv.get("TRANSACTION_FILE_PATH"));
        ITransactionRespository trRepo = new TransactionRespository(ds);
        TransactionService = new TransactionService(trRepo);
    }
    /**
     * Returns the sum of the amounts of all transactions
     */
    public double GetTotalTransactionAmount() {
        return TransactionService.GetTotalTransactionAmount();
    }

    /**
     * Returns the sum of the amounts of all transactions sent by the specified client
     */
    public double GetTotalTransactionAmountSentBy(String senderFullName) {
        return TransactionService.GetTotalTransactionAmountSentBy(senderFullName);
    }

    /**
     * Returns the highest transaction amount
     */
    public double GetMaxTransactionAmount() {
       return TransactionService.GetMaxTransactionAmount();
    }

    /**
     * Counts the number of unique clients that sent or received a transaction
     */
    public long CountUniqueClients() {
        return TransactionService.CountUniqueClients();
    }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     */
    public boolean HasOpenComplianceIssues(String clientFullName) {
        return TransactionService.GetTransactionWithComplianceIssue(clientFullName);
    }

    /**
     * Returns all transactions indexed by beneficiary name
     */
    public Map<String, List<Transaction>> GetTransactionsByBeneficiaryName() {
      return TransactionService.GetTransactionByBeneficiaryName();
    }

    /**
     * Returns the identifiers of all open compliance issues
     */
    public Set<Integer> GetUnsolvedIssueIds() {
      return TransactionService.GetUnResolvedIssuesId();
    }

    /**
     * Returns a list of all solved issue messages
     */
    public List<String> GetAllSolvedIssueMessages() {
       return TransactionService.GetResolvedIssueMessages();
    } // done

    /**
     * Returns the 3 transactions with highest amount sorted by amount descending
     */
    public List<Transaction> GetTop3TransactionsByAmount() {
      return TransactionService.GetTop3TransactionsByAmount();
    }

    /**
     * Returns the sender with the most total sent amount
     * Returns map of sender name and amount
     */
    public Map<String, Double> GetTopSender() {
      return TransactionService.GetTopSender();
    }

}
