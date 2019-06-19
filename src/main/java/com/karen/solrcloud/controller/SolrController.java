package com.karen.solrcloud.controller;

import com.karen.solrcloud.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//@RequestMapping("/robotlist")
public class SolrController {
    @Autowired
    private SolrService solrService;

    @RequestMapping("/robotlist")
    @ResponseBody
    public ArrayList robotList(@RequestBody String str)throws Exception {
        return solrService.solrQuery(str);
    }
}
