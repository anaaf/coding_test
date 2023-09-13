package com.smallworld.Common;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Mapper {
    public static <T> List<T> JsonMapper(File jsonFile, Class<T[]> type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        var trxs = Arrays.asList(objectMapper.readValue(jsonFile, type));
        return trxs;
    }
}
