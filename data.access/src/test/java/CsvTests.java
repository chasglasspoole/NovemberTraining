import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import data.access.Bass;

public class CsvTests {

	@Test
	public void canMakeHashMapFromCSV(){
		var expectedMap = new HashMap<String, String>();
		expectedMap.put("Corvette", "Warwick");
		expectedMap.put("Thumb", "Warwick");
		expectedMap.put("Streamer", "Warwick");
		expectedMap.put("Precision", "Fender");
		expectedMap.put("Jazz", "Fender");
		expectedMap.put("BB500", "Yamaha");

		var actualMap = makeMapFromCsv();


		assertEquals(actualMap, expectedMap, "Should return HashMap of Makes and Models");
	}

	@Test
	public void canHydrateCollectionOfBassObjects() {
		var expectedResult = new String[] {
				"BB500"
				,"Corvette"
				,"Jazz"
				,"Precision"
				,"Streamer"
				,"Thumb"};

		var bassMap = makeMapFromCsv();

		var keys = orderKeySet(bassMap);

		var basses = new ArrayList<Bass>();

		for(String key : keys) {
			var bass = new Bass();
			bass.setModel(key);			bass.setMake(bassMap.get(key));
			basses.add(bass);
		}

		var modelsList = new ArrayList<String>();
		for(Bass bass : basses) {
			modelsList.add(bass.getModel());
		}

		var models = modelsList.toArray(String[]::new);

		assertEquals(models, expectedResult, "Should return the model of the first object in basses collection");
	}

	public HashMap<String, String> makeMapFromCsv(){
		FileReader filereader = null;
		try {
			filereader = new FileReader("9_basses.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		CSVReader csvReader = new CSVReaderBuilder(filereader)
				.withSkipLines(1)
				.build();

		List<String[]> allData = null;
		try {
			allData = csvReader.readAll();
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}

		var bassMap = new HashMap<String, String>();

		for (String[] row : allData) {
			var key = row[1];
			var value = row[0];
			bassMap.put(key, value);
		}

		return bassMap;
	}

	public String[] orderKeySet(HashMap<String, String> map) {
		var keyObjs = map.keySet().toArray();
		Arrays.sort(keyObjs);

		var keySet = new String[keyObjs.length];
		for(int i = 0; i < keySet.length; i++) {
			keySet[i] = keyObjs[i].toString();
		}
		return keySet;
	}
}

