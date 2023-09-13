package com.smallworld.Services;

import com.smallworld.DataStore.DataStore;
import com.smallworld.Repositories.Transaction.TransactionRespository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TransactionServiceTest {

    DataStore Ds = new DataStore("transactions.json");
    TransactionRespository TransactionRespository = new TransactionRespository(Ds);
    TransactionService TransactionService = new TransactionService(TransactionRespository);

    @Test
    void CountOfUniqueClientsMustBeReturned() {
        assertEquals(TransactionService.CountUniqueClients(), 15);
        assertNotEquals(TransactionService.CountUniqueClients(), 20);
    }

    @Test
    void TopMoneySenderShouldBeReturned() {
        HashMap<String, Double> topsenders = new HashMap<>();
        topsenders.put("Arthur Shelby", 985.0);
        topsenders.put("Arthur 2 Shelby", 985.0);
        assertEquals(TransactionService.GetTopSender(), topsenders);
    }

}