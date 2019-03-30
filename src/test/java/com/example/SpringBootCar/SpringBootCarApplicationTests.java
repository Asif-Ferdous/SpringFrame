package com.example.SpringBootCar;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
public class SpringBootCarApplicationTests {

	private static String readAll(Reader reader) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		int charPointer;
		while ((charPointer = reader.read()) != -1) {
			stringBuilder.append((char) charPointer);
		}
		return stringBuilder.toString();
	}

	private static String readJsonFromUrl(final String url) throws IOException{
		InputStream inputStream = new URL(url).openStream();
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			return readAll(bufferedReader);
		} finally {
			inputStream.close();
		}
	}

	@Test
	public void isCarObjectRetrievedProbably() throws IOException{
		String jsonString = readJsonFromUrl("http://localhost:8080/hello");
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(jsonString, Car.class);
		Assert.assertNotNull(car);
		Assert.assertEquals(car.getManufacturer(), "Mercedes-Benz");
		Assert.assertEquals(car.getName(), "A 200");
	}
}
