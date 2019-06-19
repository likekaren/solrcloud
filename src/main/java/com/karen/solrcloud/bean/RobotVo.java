package com.karen.solrcloud.bean;

import lombok.Data;

@Data
public class RobotVo {
    private PageQuery pageQuery;
    private Robot robot;
    private RobotSolrVO robotSolrVO;
}
