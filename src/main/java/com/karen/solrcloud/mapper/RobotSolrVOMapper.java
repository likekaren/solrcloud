package com.karen.solrcloud.mapper;

import com.karen.solrcloud.bean.RobotSolrVO;

import java.util.List;

public interface RobotSolrVOMapper {
    public List<RobotSolrVO> getRobotAll()throws Exception;
}
