package com.weatherservicesys.dao;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.weatherservicesys.domain.WeatherBean;


@Transactional
public interface WeatherDao extends CrudRepository<WeatherBean,Integer> {
    
	@Query("select c from WeatherBean c")
	public List<WeatherBean> findAllCitys();
	
	@Query("select c from WeatherBean c Where c.name = :name")
	public List<WeatherBean> findByName(@Param("name") String name);
	
	@Query("select c from WeatherBean c Where c.date Between :from and :to")
	public List<WeatherBean> findMinMaxByTwoDates(@Param("from") Date startDate, @Param("to") Date endDate);
//	public WeatherBean findByAccountNumber(@Param("name") String name);
}
