package com.bittu.coreconcepts.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Employee employee = new Employee();
		Address address = new Address();
		address.setHouseNumber(146);
		address.setAddress("Chhatarpur");
		address.setLandmark("CDR Chowk");
		address.setCity("New Delhi");
		
		employee.setId(1);
		employee.setFirstName("Pankaj");
		employee.setMiddleName("Kumar");
		employee.setLastName("Bhadani");
		employee.setAddress(address);
		
		String fileName = "data.ser";
		String filePath = "src/main/resources/";
		File file = new File(filePath + fileName);
		
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			objectOutputStream.writeObject(employee);
		}
		
		Employee readEmployee;
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
			readEmployee = (Employee)objectInputStream.readObject();
		}
		System.out.println(readEmployee);
	}
}
