package com.smallworld.Services;

import com.smallworld.Common.IMapper;
import com.smallworld.Common.ObjectMapperWrapper;
import com.smallworld.DataStore.DataStore;
import com.smallworld.DataStore.IDataStore;
import com.smallworld.Repositories.Transaction.TransactionRespository;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TransactionServiceTest {
    Dotenv _Dotenv = Dotenv.load();
    IMapper Mapper = new ObjectMapperWrapper();
    IDataStore Ds = new DataStore(_Dotenv.get("TRANSACTION_TEST_DATA_FILE_PATH"), Mapper);
    TransactionRespository TransactionRespository = new TransactionRespository(Ds);
    TransactionService TransactionService = new TransactionService(TransactionRespository);

    @Test
    void CountOfUniqueClientsMustBeReturned() {
        assertEquals(TransactionService.CountUniqueClients(), 16);
        assertNotEquals(TransactionService.CountUniqueClients(), 20);
    }

    @Test
    void TopMoneySenderShouldBeReturned() {
        HashMap<String, Double> topsenders = new HashMap<>();
        topsenders.put("Arthur 2 Shelby", 985.0);
        assertNotEquals(TransactionService.GetTopSender(), topsenders);
        topsenders.clear();
        topsenders.put("Anaaf Jawed", 986.0);
        assertEquals(TransactionService.GetTopSender(), topsenders);
    }

    @Test
    void ClientWithAnyComplianceIssue() {
        assertEquals(TransactionService.GetTransactionWithComplianceIssue("Billy Kimber"), false );
        assertEquals(TransactionService.GetTransactionWithComplianceIssue( "Tom Shelby"), true);
    }

}