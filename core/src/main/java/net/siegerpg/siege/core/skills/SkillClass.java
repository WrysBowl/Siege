package net.siegerpg.siege.core.skills;

public enum SkillClass {
	MAGE("Mage", "mage"),
	WARRIOR("Warrior", "warrior"),
	ARCHER("Archer", "archer");

	/**
	 * The name assigned to the class
	 */
	private String name;
	/**
	 * The id of the class (should not change unless you want people to lose skill progress)
	 */
	private String id;

	public String getName() {

		return this.name;
	}

	public String getId() {

		return this.id;
	}

	private SkillClass(String name, String id) {

		this.id = id;
		this.name = name;
	}

}
