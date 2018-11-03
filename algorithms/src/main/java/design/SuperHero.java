package design;

import java.lang.reflect.Constructor;

/**
 * Created by archithrapaka on 2/23/17.
 */
public class SuperHero {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;
        try {
            Constructor[] constructors =
                    Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                //constructor.
                instance2 = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode():- "
                + instance1.hashCode());
        System.out.println("instance2.hashCode():- "
                + instance2.hashCode());

    }
}
