

public class LocationObjectMothers {

	public static LocationObjectMother NewOrleans() {
		
		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(cities.NewOrleans)
				.build();
	}

}
