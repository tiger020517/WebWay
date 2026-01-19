package jjsspp.wsdp3.bean;

import java.sql.Timestamp;
import lombok.Data;

public class DonorVO {
	private int sid;
	private String name;
	private int age;
	private String contact;
	private int height;
	private int weight;
	private String blood_type; // 변수명 snake_case 유지
	private String smoker;
	private String organ;
	private String health;
	private Timestamp regdate;
	private String photo;

	// Getter & Setter
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	// [중요] JSP에서 ${u.blood_type}을 찾을 수 있도록 메서드 이름도 snake_case로 작성
	public String getBlood_type() {
		return blood_type;
	}
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}

	public String getSmoker() {
		return smoker;
	}
	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	public String getOrgan() {
		return organ;
	}
	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}

	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}