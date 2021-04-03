package com.straders.service.algobase.utils;

import java.sql.Date;
import java.sql.Time;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataUtils {

	protected ObjectMapper mapObj = new ObjectMapper();

	public void printCurrentTime() {
		System.out.println(getCurrentTime());
	}

	protected Object getMapFromJson(String content, String key) {
		Map<String, Object> responseMap = new HashMap<>();
		try {
			responseMap = mapObj.readValue(content, new TypeReference<Map<String, Object>>() {
			});
			return responseMap.get(key);
		} catch (Exception e) {
			e.printStackTrace();
			return responseMap;
		}
	}

	protected Object getListFromJson(String content, String key) {
		List<Map<String, Object>> responseList = new ArrayList<>();
		try {
			responseList = mapObj.readValue(content, new TypeReference<List<Map<String, Object>>>() {
			});
			return responseList;
		} catch (Exception e) {
			e.printStackTrace();
			return responseList;
		}
	}

	protected Map<String, Object> getMapFromObject(String content) {
		Map<String, Object> responseMap = new HashMap<>();
		try {
			responseMap = mapObj.readValue(content, new TypeReference<Map<String, Object>>() {
			});
			return responseMap;
		} catch (Exception e) {
			e.printStackTrace();
			return responseMap;
		}
	}

	protected List<Map<String, Object>> getListFromObject(String content) {
		List<Map<String, Object>> responseList = new ArrayList<>();
		try {
			responseList = mapObj.readValue(content, new TypeReference<List<Map<String, Object>>>() {
			});
			return responseList;
		} catch (Exception e) {
			e.printStackTrace();
			return responseList;
		}
	}

	protected Map<String, Object> castMap(Object object) {
		return (Map<String, Object>) object;
	}

	protected List<Map<String, Object>> castList(Object object) {
		return (List<Map<String, Object>>) object;
	}

	protected Map<String, Object> getDataMap(List<Map<String, Object>> list) {
		return list.stream().findFirst().isPresent() ? list.stream().findFirst().get() : Collections.emptyMap();
	}

	public boolean checkNonNull(Object obj) {
		return Objects.nonNull(obj);
	}

	public Date getToday() {
		return new Date(Instant.now().toEpochMilli());
	}

	public String getCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public Time getTime() {
		return new Time(System.currentTimeMillis());
	}

	public Date getTomorrow() {
		return new Date(Instant.now().plus(Duration.ofDays(1)).toEpochMilli());
	}

	public Double makeDouble(Object data) {
		return toDecimal(Double.valueOf(String.valueOf(data)));
	}

	public Integer makeInteger(Object data) {
		return (int) Math.round(Double.valueOf(String.valueOf(data)));
	}

	public StringEntity makeEntity(Map<String, String> orderMap) {
		JSONObject json = new JSONObject(orderMap);
		try {
			return new StringEntity(json.toString());
		} catch (Exception e) {
			return null;
		}
	}

	public String toString(Object data) {
		return String.valueOf(data);
	}

	public Double toDecimal(Object data) {
		Double number = Math.ceil(Double.valueOf(data.toString()) / 0.05) * 0.05;
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(number));
	}
}
