package java9;

public interface test {

    default void defaultMethod() {
        privateMethod("Hello from the default method!");
    }

    private void privateMethod(final String string) {
        System.out.println(string);
    }
}