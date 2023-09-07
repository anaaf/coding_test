package com.smallworld.Repositories.Transaction;

import com.smallworld.Model.Transaction;
import com.smallworld.Repositories.Base.IBaseRepository;

public interface ITransactionRespository extends IBaseRepository {
    Transaction FindBySenderName(String name);
    Transaction FindByClientName(String name);
}
