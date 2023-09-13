package com.smallworld.Repositories.Transaction;

import com.smallworld.Model.Transaction;
import com.smallworld.Repositories.Base.IBaseRepository;

import java.util.*;

public interface ITransactionRespository extends IBaseRepository<Transaction> {
    double GetMaxTransactionAmount();
    double GetTotalTransactionAmountSentBy(String senderFullName);
    double GetTotalTransactionAmount();
    Collection<Transaction> GetTopSender();
    Collection<Transaction> GetTop3TransactionsByAmount();
    HashSet<String> GetUniqueClients();
    Collection<Transaction> GetUniqueTransactions();
    Collection<Transaction> GetTransactionWithComplianceIssue(String clientName);
    Map<String, List<Transaction>> GetTransactionByBeneficiaryName();
    Set<Integer> GetUnResolvedIssuesId();
    List<String> GetResolvedIssueMessages();
}
