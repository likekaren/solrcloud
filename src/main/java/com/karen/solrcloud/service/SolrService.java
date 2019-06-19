package com.karen.solrcloud.service;


import com.karen.solrcloud.result.ResultInfo;

import java.util.ArrayList;

public interface SolrService {
    ResultInfo importAllRobots() throws Exception;
    ArrayList solrQuery(String str) throws Exception;
    ResultInfo solrDelete() throws Exception;
}
