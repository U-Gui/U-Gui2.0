package cn.edu.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.edu.neu.mapper.PollingMapper;

/**
 * 接收硬件端轮询
 * @author bc
 * @date 2018年11月27日
 */
@Controller
@RequestMapping("/polling/")
public class PollingController {

	@Autowired
	private PollingMapper pollingMapper;
	
	/*@PostMapping("accept")
	@ResponseBody
	public Map<String, Object> accept(@RequestBody JSONObject json) {
		int cabinetId = json.getInteger("cabinetId");
//		List<Object> boxid = json.getJSONArray("boxid");
		JSONArray arr = json.getJSONArray("boxid");
		pollingMapper.updateBoxStatus(arr);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("boxids", pollingMapper.needOpenBox(cabinetId));
		return resultMap;
	}*/
	@PostMapping("accept")
	@ResponseBody
//	public void accept(@RequestParam(value="boxids[]") List<Integer> ids, HtpServletRequest request, HttpServletResponse response) {
	public String accept(@RequestBody JSONObject json) {
		List<Object> boxids = json.getJSONArray("boxids");
		pollingMapper.updateBoxStatus(boxids);
		StringBuilder sb = new StringBuilder();
		boxids = pollingMapper.needOpenBox(json.getInteger("cabinetId"));
		for(int i=0; i<boxids.size(); i++)
			sb.append(boxids.get(i)+",");
		return sb.toString();
	}
	
}
