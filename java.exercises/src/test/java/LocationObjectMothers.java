

public class LocationObjectMothers {

	public static LocationObjectMother NewOrleans() {
		
		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(cities.NewOrleans)
				.withZipcode(cities.NewOrleans.Zipcode)
				.build();
	}
	
	public static LocationObjectMother Houston() {
		
		return new LocationBuilder()
			.withState(States.Texas)
			.withCity(cities.Houston)
			.withZipcode(cities.Houston.Zipcode)
			.build();
		
	}

}
