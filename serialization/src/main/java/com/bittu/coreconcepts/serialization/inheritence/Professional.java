package com.bittu.coreconcepts.serialization.inheritence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Professional extends Person implements Serializable{

	private static final long serialVersionUID = 1631744871002594823L;
	private String profession;
	private String income;
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeInt(getAge());
		oos.writeObject(getName());
		oos.writeObject(getGender());
	}
	
	private void readObject(ObjectInputStream oos) throws ClassNotFoundException, IOException {
		oos.defaultReadObject();
		setAge(oos.readInt());
		setName((String)oos.readObject());
		setGender((String) oos.readObject());
	}
	
	@Override
	public String toString() {
		return "Professional [profession=" + profession + ", income=" + income + ", age=" + age + ", name=" + name
				+ ", gender=" + gender + "]";
	}

}
