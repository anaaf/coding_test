package com.smallworld.Repositories.Base;

import java.util.Collection;
import java.util.function.Predicate;

public interface IBaseRepository<T> {
    Collection<T> GetAll();
    Collection<T> Find(Predicate<T> predicate);
}
