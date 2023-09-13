package com.smallworld.Repositories.Transaction;

import com.smallworld.DataStore.DataStore;
import com.smallworld.DataStore.IDataStore;
import com.smallworld.Model.Transaction;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TransactionRespositoryTest {
    Dotenv dotenv = Dotenv.load();
    IDataStore Ds = new DataStore(dotenv.get("TRANSACTION_FILE_PATH"));
    TransactionRespository TransactionRespository = new TransactionRespository(Ds);
    @Test
    void SumOfAllTransactionsAmount() {
        assertEquals(TransactionRespository.GetTotalTransactionAmount(), 3874.17);
    }

    @Test
    void MaxTransactionAmountShouldBeReturned() {
        assertEquals(TransactionRespository.GetMaxTransactionAmount(), 985.0);
        assertNotEquals(TransactionRespository.GetMaxTransactionAmount(), 100);
    }

    @Test
    void SumOfAmountSendBySender() {
        assertEquals(TransactionRespository.GetTotalTransactionAmountSentBy("Tom Shelby"), 678.06);
        assertEquals(TransactionRespository.GetTotalTransactionAmountSentBy("Aunt Polly"), 101.02);
        assertEquals(TransactionRespository.GetTotalTransactionAmountSentBy("Grace Burgess"), 666.0);
    }

    @Test
    void TopThreeTransactionByAmountShouldBeReturned() {
        Transaction trx1 = new Transaction();
        Transaction trx2 = new Transaction();
        Transaction trx3 = new Transaction();
        trx1.setMtn((long) 5465465);
        trx2.setMtn((long) 5465466);
        trx3.setMtn((long) 32612651);
        List<Transaction> transactionList = Stream.of(trx1, trx2, trx3).collect(Collectors.toList());

        assertEquals(TransactionRespository.GetTop3TransactionsByAmount().stream().map(Transaction::getMtn).collect(Collectors.toList()),
                transactionList.stream().map(Transaction::getMtn).collect(Collectors.toList()) );
    }

    @Test
    void ReturnsUnResolvedIssuesId() {
        assertEquals(TransactionRespository.GetUnResolvedIssuesId(), Stream.of(1,3,15,54,99).collect(Collectors.toSet()));
    }

    @Test
    void ReturnsUnResolvedIssuesMessage() {
        List<String> issues = new ArrayList<>();
        issues.add("Never gonna give you up");
        issues.add("Never gonna let you down");
        issues.add("Never gonna run around and desert you");
        assertEquals(TransactionRespository.GetResolvedIssueMessages(), issues);
    }

    @Test
    void TransactionIdOfUniqueTransactionsMustMatch() {
        var expected = new ArrayList<>(TransactionRespository.GetUniqueTransactions().stream().map(Transaction::getMtn).toList());
        long[] testData = {5465466, 663458, 1284564, 96132456, 5465465, 1651665, 6516461, 32612651, 36448252, 645645111, 45431585};
        List<Long> actual = new ArrayList<>(Arrays.stream(testData).boxed().toList());
        Collections.sort(expected);
        Collections.sort(actual);
        assertEquals(expected, actual);
    }

    @Test
    void TransactionCountForBeneficiariesMustBeEqual() {
        var trx = TransactionRespository.GetTransactionByBeneficiaryName();
        for (var t: trx.entrySet()) {
            if(t.getKey().equals("Ben Younger")) {
                assertEquals(t.getValue().size(), 2);
            } else {
                assertEquals(t.getValue().size(), 1);
            }
        }
    }
}