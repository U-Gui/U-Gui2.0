package cn.edu.neu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PollingMapper {

	public List<Object> needOpenBox(int cabinetId);
	public void updateBoxStatus(@Param("boxids") List<Object> boxids);
	
}
