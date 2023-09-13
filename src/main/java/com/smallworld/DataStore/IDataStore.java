package com.smallworld.DataStore;

import java.util.Collection;

public interface IDataStore {
    <T> Collection<T> Map(Class<T[]> type);
;
}
