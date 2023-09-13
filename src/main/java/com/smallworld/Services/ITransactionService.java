package com.smallworld.Services;

import com.smallworld.Model.Transaction;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ITransactionService {

    double GetTotalTransactionAmount();
    double GetTotalTransactionAmountSentBy(String senderFullName);
    double GetMaxTransactionAmount();
    Map<String, Double> GetTopSender();
    List<Transaction> GetTop3TransactionsByAmount();
    long CountUniqueClients();
    List<String> GetResolvedIssueMessages();
    Set<Integer> GetUnResolvedIssuesId();
    Map<String, List<Transaction>>GetTransactionByBeneficiaryName();
    boolean GetTransactionWithComplianceIssue(String clientName);
}
