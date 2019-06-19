package com.karen.solrcloud;

import com.karen.solrcloud.bean.RobotSolrVO;
import com.karen.solrcloud.service.SolrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolrcloudApplicationTests {

    @Autowired
    SolrService solrService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testsolr() throws Exception {
        ArrayList list = solrService.solrQuery("停止，不正常");

       for(Object o : list){
           System.out.println(o);
       }

    }

}
