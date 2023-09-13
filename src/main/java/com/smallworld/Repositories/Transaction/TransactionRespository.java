package com.smallworld.Repositories.Transaction;

import com.smallworld.DataStore.IDataStore;
import com.smallworld.Model.Transaction;
import com.smallworld.Repositories.Base.BaseRepositoryFile;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionRespository extends BaseRepositoryFile<Transaction> implements ITransactionRespository {

    private IDataStore DataStore;

    public TransactionRespository(IDataStore TransactionDataStore){
        super(TransactionDataStore,  Transaction[].class);
        DataStore = TransactionDataStore;
    }

    public double GetMaxTransactionAmount() {
        return GetUniqueTransactions()
                .stream()
                .map(Transaction::getAmount)
                .max(Comparator.naturalOrder())
                .get();
//
//        List<Double> amounts = transactions.stream().map(Transaction::getAmount);
//        var max =  amounts.stream().max(Double::compareTo).get();
//        return max;
    }

    public Collection<Transaction> GetUniqueTransactions() {
        return GetAll().stream().distinct().toList();
    }

    public Collection<Transaction> GetUniqueTransactions(Collection<Transaction> transactions) {
        return transactions.stream().distinct().toList();
    }

    public double GetTotalTransactionAmountSentBy(String senderFullName) {
        return GetSum(
                Find(trx -> trx.getSenderFullName().equals(senderFullName))
                .stream()
                .distinct()
                .map(Transaction::getAmount)
                .toList()
            );
    }

    public double GetTotalTransactionAmount() {
        return
                GetUniqueTransactions()
                .stream()
                .map(Transaction::getAmount)
                .mapToDouble(Double::doubleValue).sum();
    }

    public Collection<Transaction> GetTopSender() {
        var maxTrx = GetMaxTransactionAmount();
        var topSender = Find(trx -> trx.getAmount().equals(maxTrx));
        return GetUniqueTransactions(topSender);
    }

    public Collection<Transaction> GetTop3TransactionsByAmount() {
        return GetUniqueTransactions().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public HashSet<String> GetUniqueClients() {
        var trx = this.GetUniqueTransactions();
        HashSet<String> clients = new HashSet<>();
        // using name and age of client to get unique clients
        for(var t : trx ) {
            clients.add(t.getSenderFullName() + t.getSenderAge());
            clients.add(t.getBeneficiaryFullName() + t.getBeneficiaryAge());
        }
        return clients;
    }

    public Collection<Transaction> GetTransactionWithComplianceIssue(String clientName) {
               return Find(t -> (t.getBeneficiaryFullName().equals(clientName) ||
                        t.getSenderFullName().equals(clientName)) &&
                        t.getIssueId() != null &&
                        t.getIssueSolved().equals(false));
    }

    public Map<String, List<Transaction>> GetTransactionByBeneficiaryName() {
        return GetUniqueTransactions()
                    .stream()
                    .collect(Collectors.groupingBy(Transaction::getBeneficiaryFullName));
    }

    public Set<Integer> GetUnResolvedIssuesId() {
        return Find(t -> t.getIssueSolved().equals(false))
                .stream()
                .map(Transaction::getIssueId)
                .collect(Collectors.toSet());
    }
    public List<String> GetResolvedIssueMessages() {
        return Find(t -> t.getIssueSolved().equals(true) && t.getIssueId() != null)
                .stream()
                .distinct()
                .map(Transaction::getIssueMessage)
                .toList();
    }


    private double GetSum(Collection<Double> collection) {
        var sum = 0.0;
        for (var num : collection) {
            sum = sum + num;
        }
        return sum;
    }
}
