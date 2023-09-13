package com.smallworld;

public class TransactionFetcherApp {


    public static void main(String [] args) {
        TransactionDataFetcher trxFetcher = new TransactionDataFetcher();
        trxFetcher.GetTotalTransactionAmount();
        trxFetcher.GetTransactionsByBeneficiaryName();
        trxFetcher.CountUniqueClients();
        trxFetcher.GetTop3TransactionsByAmount();
        trxFetcher.GetTopSender();
        trxFetcher.GetMaxTransactionAmount();
        trxFetcher.GetTotalTransactionAmountSentBy("Tom Shelby");
        trxFetcher.HasOpenComplianceIssues("Tom Shelby");
        trxFetcher.GetAllSolvedIssueMessages();
        trxFetcher.GetUnsolvedIssueIds();
    }
}
