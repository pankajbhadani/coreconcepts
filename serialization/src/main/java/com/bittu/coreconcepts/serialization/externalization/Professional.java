package com.bittu.coreconcepts.serialization.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Professional extends Person implements Externalizable{

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
	

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setAge(in.readInt());
		setName((String)in.readObject());
		setGender((String)in.readObject());
		setProfession((String)in.readObject());
		//setIncome((String)in.readObject());
		//No need to include the fields that you consider is not supposed to be serialized
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(getAge());
		out.writeObject(getName());
		out.writeObject(getGender());
		out.writeObject(getProfession());
		//out.writeObject(getIncome());
		//No need to include the fields that you consider is not supposed to be serialized
	}
	
	@Override
	public String toString() {
		return "Professional [profession=" + profession + ", income=" + income + ", age=" + age
				+ ", name=" + name + ", gender=" + gender + "]";
	}
}
