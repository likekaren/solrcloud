package com.karen.solrcloud.service;


import com.karen.solrcloud.bean.RobotSolrVO;
import com.karen.solrcloud.mapper.RobotSolrVOMapper;
import com.karen.solrcloud.result.ResultInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolrServiceImpl implements SolrService {
    @Autowired(required=false)
    private RobotSolrVOMapper robotSolrVOMapper;

    private final static String BASE_URL = "http://47.103.29.1:8080/solr";

    @Override
    public ResultInfo importAllRobots() throws Exception {
//        HttpSolrClient solrClient = getSolrClient();
        HttpSolrClient.Builder builder = new HttpSolrClient.Builder(BASE_URL);
        SolrClient solrClient = builder.build();

        List<RobotSolrVO> list = robotSolrVOMapper.getRobotAll();

        for (RobotSolrVO robotSolrVO : list) {
            //创建一个SolrInputDocument对象
            SolrInputDocument document = new SolrInputDocument();
            document.setField("id",robotSolrVO.getId());
            document.setField("rname",robotSolrVO.getRname());
            document.setField("status",robotSolrVO.getStatus());
            document.setField("rnote",robotSolrVO.getRnote());
            document.setField("ex1",robotSolrVO.getEx1());
            document.setField("ex2",robotSolrVO.getEx2());
            document.setField("ex3",robotSolrVO.getEx3());
            document.setField("ex4",robotSolrVO.getEx4());
            document.setField("ex5",robotSolrVO.getEx5());
            document.setField("ex6",robotSolrVO.getEx6());

            //写入索引库
            solrClient.add("mesrobot",document);

        }
        //提交修改
        solrClient.commit("mesrobot");
        return null;
    }



    @Override
    public ArrayList solrQuery(String fq) throws Exception {

        HttpSolrClient.Builder builder = new HttpSolrClient.Builder(BASE_URL);
        SolrClient solrClient = builder.build();
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setFilterQueries(fq);
        QueryResponse response = solrClient.query("mesrobot",query);
        SolrDocumentList results = response.getResults();

        ArrayList list = new ArrayList();
        for (SolrDocument result: results){
            RobotSolrVO rb = new RobotSolrVO();
            rb.setId((String)result.get("id"));
            rb.setRname((String)result.get("rname"));
            rb.setRnote((String)result.get("rnote"));
            rb.setStatus((String)result.get("status"));
            rb.setEx1((String)result.get("ex1"));
            rb.setEx2((String)result.get("ex2"));
            rb.setEx3((String)result.get("ex3"));
            rb.setEx4((String)result.get("ex4"));
            rb.setEx5((String)result.get("ex5"));
            rb.setEx6((String)result.get("ex6"));

            list.add(rb);

        }
        return list;
    }

    @Override
    public ResultInfo solrDelete() throws Exception {
        HttpSolrClient.Builder builder = new HttpSolrClient.Builder(BASE_URL);
        SolrClient solrClient = builder.build();
//        solrClient.deleteById("mesrobot","1");
        // 还可以通过查询条件删除
        // solrClient.deleteByQuery("mesrobot", "查询条件");
        // 提交删除
        solrClient.commit("mesrobot");
        return null;
    }


}
