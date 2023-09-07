package com.smallworld.Repositories.Base;

import java.util.Collection;

public interface IBaseRepository<T> {
    Collection<T> GetAll();
}
