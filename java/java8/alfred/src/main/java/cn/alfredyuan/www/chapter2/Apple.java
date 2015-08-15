package cn.alfredyuan.www.chapter2;

public class Apple {
	private Integer weight;
	private String color;

	public Apple() {
		this.weight = 0;
		this.color = "";
	}
	
	public Apple(Integer weight) {
		this.weight = weight;
		this.color = "";
	}
	
	public Apple(String color) {
		this.color = color;
		this.weight = 0;
	}
	
	public Apple(Integer weight, String color){
		this.weight = weight;
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "Apple{" +
				"color='" + color + '\'' +
				", weight=" + weight +
				'}';
	}
}
