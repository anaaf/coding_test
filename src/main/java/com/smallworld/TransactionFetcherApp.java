package com.smallworld;

public class TransactionFetcherApp {


    public static void main(String [] args) {
        TransactionFetcherApp trxApp = new TransactionFetcherApp() ;
        trxApp.PrintAllTransactionData();
    }

    public void PrintAllTransactionData() {
        TransactionDataFetcher trxFetcher = new TransactionDataFetcher();
        System.out.println("Total Transaction: " + trxFetcher.GetTotalTransactionAmount());
        System.out.println();
        System.out.println("Unique clients count: " + trxFetcher.CountUniqueClients());
        System.out.println();
        System.out.println("Max Transaction Amount: " + trxFetcher.GetMaxTransactionAmount());
        System.out.println();
        System.out.println("Get Total Transaction Sent: " + trxFetcher.GetTotalTransactionAmountSentBy("Tom Shelby"));
        System.out.println();
        System.out.println("Has Open Compliant Issues: " + trxFetcher.HasOpenComplianceIssues("Tom Shelby"));
        System.out.println();
        System.out.println("Get All Solved Issue Messages: " + trxFetcher.GetAllSolvedIssueMessages());
        System.out.println();
        System.out.println("Get Unsolved Issue Ids: " + trxFetcher.GetUnsolvedIssueIds());
        System.out.println();
        System.out.println("Top 3 Transactions: " + trxFetcher.GetTop3TransactionsByAmount());
        System.out.println();
        System.out.println("Get Top Sender: " + trxFetcher.GetTopSender());
        System.out.println();
        System.out.println("Get Transaction By Beneficiary Name\n");
        for(var t:  trxFetcher.GetTransactionsByBeneficiaryName().entrySet()) {
            System.out.println(t.getKey() + ": " + t.getValue().toString());
        }
    }

}
