package com.bittu.coreconcepts.serialization.inheritence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationWithInheritenceTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Professional professional = new Professional();
		professional.setAge(30);
		professional.setGender("Male");
		professional.setName("Pankaj Kumar Bhadani");
		professional.setProfession("Software Engineer");
		professional.setIncome("50000");
		professional.setPan("XX");
		
		String fileName = "dataSerializationWithInheritenceTest.ser";
		String filePath = "src/main/resources/";
		File file = new File(filePath + fileName);
		
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			objectOutputStream.writeObject(professional);
		}
		
		Professional readProfessional;
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
			readProfessional = (Professional)objectInputStream.readObject();
		}
		System.out.println(readProfessional);
	}
}
