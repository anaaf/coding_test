package com.smallworld.DataStore;

import com.smallworld.Common.IMapper;
import com.smallworld.Common.ObjectMapperWrapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DataStore implements IDataStore  {
    private String Filepath;
    private IMapper Mapper;
    public DataStore(String filepath, IMapper mapper) {
        Filepath = filepath;
        Mapper = mapper;
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
