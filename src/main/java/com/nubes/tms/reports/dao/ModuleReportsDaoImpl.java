package com.nubes.tms.reports.dao;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.nubes.tms.reports.dto.ModuleCountDTO;
import com.nubes.tms.reports.dto.ModulePriorityDTO;
import com.nubes.tms.reports.dto.ModuleStatusDTO;

@Repository
public class ModuleReportsDaoImpl implements ModuleReportsDao {
	
	private static final Logger log = LoggerFactory.getLogger(ModuleReportsDaoImpl.class);
	
	private final MongoOperations mongoOperations;
	
	@Autowired
	public ModuleReportsDaoImpl(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	
	@Override
	public List<ModuleCountDTO> getModuleIssuesCount() {
		Aggregation agg = newAggregation(group("module").count().as("count"),
				                         project("count").and("module").previousOperation(),
				                         sort(Sort.Direction.DESC,"count"));
		
		AggregationResults<ModuleCountDTO> res = mongoOperations.aggregate(agg, "issue", ModuleCountDTO.class);
		List<ModuleCountDTO> modCount = res.getMappedResults();
		
		log.info("Total modules with issues are:{}", modCount.size());
		
		return modCount;
	}


	@Override
	public List<ModuleCountDTO> getModuleIssuesCountByOrg(String orgName) {
		Aggregation agg = newAggregation(match(Criteria.where("orgName").is(orgName)),
				                          group("module").count().as("count"),
				                          project("count").and("module").previousOperation(),
				                          sort(Sort.Direction.DESC,"count"));
		
		AggregationResults<ModuleCountDTO> res = mongoOperations.aggregate(agg, "issue", ModuleCountDTO.class);
		List<ModuleCountDTO> modCount = res.getMappedResults();
		
		 log.info("Total modules of organization with issues are:{}", modCount.size());
		
		 return modCount;
	}


	@Override
	public List<ModulePriorityDTO> getModulePriorityCount(String mName) {
		Aggregation agg = newAggregation(match(Criteria.where("module").is(mName)),
				                        group("priority").count().as("count"),
				                        project("count").and("priority").previousOperation());
		
		AggregationResults<ModulePriorityDTO> res = mongoOperations.aggregate(agg, "issue", ModulePriorityDTO.class);
		List<ModulePriorityDTO> modPriorityCount = res.getMappedResults();
		
		log.info("Module is having total of {} priorities",modPriorityCount.size());
		
		return modPriorityCount;
	}


	@Override
	public List<ModuleStatusDTO> getModuleStatusCount(String mName) {
		Aggregation agg = newAggregation(match(Criteria.where("module").is(mName)),
                						group("status").count().as("count"),
                						project("count").and("status").previousOperation());

     	AggregationResults<ModuleStatusDTO> res = mongoOperations.aggregate(agg, "issue", ModuleStatusDTO.class);
        List<ModuleStatusDTO> modStatusCount = res.getMappedResults();
        
        log.info("Module is having total of {} status", modStatusCount.size());
        
        return modStatusCount;
	}
	
	

}
