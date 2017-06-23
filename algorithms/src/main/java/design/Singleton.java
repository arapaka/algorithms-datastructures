package design;

/**
 * Created by archith.rapaka on 6/14/17.
 */
public class Singleton {

	private static Singleton SINGLETON = new Singleton();

	private Singleton() {

	}

	public static Singleton getInstance() {
		 if(SINGLETON == null) {
			 SINGLETON = new Singleton();
		 }
		return SINGLETON;
	}

}
