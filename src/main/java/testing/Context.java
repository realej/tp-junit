package testing;

import java.util.HashMap;

public class Context {
	HashMap<String, Object> map;
	
	public Object getObject(String key) {
		return map.get(key);
	}
	
	public void setObject(String key, Object value) {
		map.put(key, value);
	}
}
