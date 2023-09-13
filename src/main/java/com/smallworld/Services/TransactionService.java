package com.smallworld.Services;

import com.smallworld.Model.Transaction;
import com.smallworld.Repositories.Transaction.ITransactionRespository;

import java.util.*;

public class TransactionService implements ITransactionService{

    ITransactionRespository TransactionRepository;
    public TransactionService(ITransactionRespository transactionRespository) {
        TransactionRepository = transactionRespository;
    }

    public double GetTotalTransactionAmount() {
        return TransactionRepository.GetTotalTransactionAmount();
    }

    public double GetTotalTransactionAmountSentBy(String senderFullName) {
       return TransactionRepository.GetTotalTransactionAmountSentBy(senderFullName);
    }

    public double GetMaxTransactionAmount() {
        return TransactionRepository.GetMaxTransactionAmount();
    }

    public Map<String, Double> GetTopSender() {
        Map<String, Double> TopSenderNames = new HashMap<>();
        Collection<Transaction> maxTrx = TransactionRepository.GetTopSender();
        for(var trx: maxTrx) {
            TopSenderNames.put(trx.getSenderFullName(), trx.getAmount());
        }
        return TopSenderNames;
    }

    public List<Transaction> GetTop3TransactionsByAmount() {
        return TransactionRepository.GetTop3TransactionsByAmount().stream().toList();
    }

    public long CountUniqueClients() {
       var uniqueClients = TransactionRepository.GetUniqueClients();
       return uniqueClients.size();
    }

    public List<String> GetResolvedIssueMessages() {
        return TransactionRepository.GetResolvedIssueMessages();
    }

    public Set<Integer> GetUnResolvedIssuesId() {
        return TransactionRepository.GetUnResolvedIssuesId();
    }

    public Map<String, List<Transaction>> GetTransactionByBeneficiaryName() {
       return TransactionRepository.GetTransactionByBeneficiaryName();
    }

    public boolean GetTransactionWithComplianceIssue(String clientName) {
        return !TransactionRepository.GetTransactionWithComplianceIssue(clientName).isEmpty();
    }
}
