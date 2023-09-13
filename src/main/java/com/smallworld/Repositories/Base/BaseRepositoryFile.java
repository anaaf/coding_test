package com.smallworld.Repositories.Base;

import com.smallworld.DataStore.IDataStore;

import java.util.Collection;
import java.util.function.Predicate;

public class BaseRepositoryFile<T> implements IBaseRepository<T>{

    private IDataStore DataStore;
    private Class<T[]> Type;
    public BaseRepositoryFile(IDataStore dataStore, Class<T[]> type) {
        DataStore = dataStore;
        Type = type;
    }
    public Collection<T> GetAll()  {
       return DataStore.<T>Map(Type);
    }
    public Collection<T> Find(Predicate<T> predicate) {
        return this.<T>GetAll().stream().filter(predicate).toList();
    }
}
