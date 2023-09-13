package com.smallworld.DataStore;

import com.smallworld.Common.Mapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DataStore implements IDataStore  {
    private String Filepath;
    public DataStore(String filepath) {
        Filepath = filepath;
    }

    public <T> Collection<T> Map(Class<T[]> type) {
        try {
            return Mapper.JsonMapper(new File(Filepath), type);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
