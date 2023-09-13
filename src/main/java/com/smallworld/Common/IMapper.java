package com.smallworld.Common;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IMapper {
     <T> List<T> JsonMapper(File jsonFile, Class<T[]> type) throws IOException;
}
