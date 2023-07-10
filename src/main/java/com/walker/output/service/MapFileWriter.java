package com.walker.output.service;

import com.walker.mapElements.model.Map;

public interface MapFileWriter
{
    void writeMapFile(Map map, String file);
}