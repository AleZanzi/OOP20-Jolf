package model;

public enum EMap {

	TEST("Test"), HOLE_1("Hole 1"), HOLE_2("Hole 2"), 
	HOLE_3("Hole 3"), HOLE_4("Hole 4"), HOLE_5("Hole 5"),
	HOLE_6("Hole 6");

	private final String name;
	
	private EMap(String name) {
		this.name = name;
	}
	
	public static EMap get(String mapName) {
		EMap result = null;
		for (EMap map : EMap.values()) {
			if (map.getName().equals(mapName)) {
				result = map;
			}
		}
		return result;
	}

	public String getName() {
		return this.name;
	}

}