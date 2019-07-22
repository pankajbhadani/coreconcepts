package com.bittu.coreconcepts.serialization.inheritence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Professional extends Person implements Serializable{

	private static final long serialVersionUID = 1631744871002594823L;
	private String profession;
	private String income;
	//confidential information that you donot want to serialize and share across system you can mark them transient.
	//Also there are different logger and other variable which you donot want to serialize as there is no point serializing them, marke them as transient.
	private transient String pan;
	
	
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
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
		return "Professional [profession=" + profession + ", income=" + income + ", pan=" + pan + ", age=" + age
				+ ", name=" + name + ", gender=" + gender + "]";
	}
}
