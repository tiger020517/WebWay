package com.example;

import java.util.*;

public class Repository {
	private static List<Map<String, String>> dataList = new ArrayList<>();
	private static int sequence = 1;

	static {
		Map<String, String> m = new HashMap<>();
		m.put("id", String.valueOf(sequence++));
		m.put("name", "김준형");
		m.put("age", "24");
		m.put("contact", "010-1234-5678");
		m.put("height", "175");
		m.put("weight", "70");
		m.put("blood_type", "A");
		m.put("smoker", "yes");
		m.put("organ", "신장");
		m.put("health", "매우 건강함");
		m.put("date", "2025-11-25");
		dataList.add(m);
	}

	public static void add(Map<String, String> data) {
		data.put("id", String.valueOf(sequence++));
		dataList.add(data);
	}

	public static List<Map<String, String>> getAll() {
		return dataList;
	}

	public static Map<String, String> getById(String id) {
		for (Map<String, String> m : dataList) {
			if (m.get("id").equals(id)) return m;
		}
		return null;
	}

	public static void delete(String id) {
		dataList.removeIf(m -> m.get("id").equals(id));
	}

	public static void update(Map<String, String> newData) {
		Map<String, String> oldData = getById(newData.get("id"));
		if (oldData != null) {
			oldData.putAll(newData);
		}
	}
}