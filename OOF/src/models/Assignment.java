package models;


public class Assignment {
	
	private String name;
	private float pointsObtained;
	private float pointsPossible;
	
	public Assignment(String name, float pointsObtained, float pointsPossible) {
		setName(name);
		setPointsPossible(pointsPossible);
		setPointsObtained(pointsObtained);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPointsObtained() {
		return pointsObtained;
	}

	public void setPointsObtained(float pointsObtained) {
		this.pointsObtained = pointsObtained;
	}

	public float getPointsPossible() {
		return pointsPossible;
	}

	public void setPointsPossible(float pointsPossible) {
		this.pointsPossible = pointsPossible;
	}
	
	

}
