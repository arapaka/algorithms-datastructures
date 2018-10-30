package java9;

public class ProcessHandleTest {

    public static void getall() {
        ProcessHandle.allProcesses()
                .filter(i -> i.info().user().toString().contains("shalkota"))
                .forEach(o -> o.destroyForcibly());
    }
    public static String listOsUser(ProcessHandle handle){
        ProcessHandle.Info procInfo = handle.info();
        return handle.pid() + ": " +procInfo.user();
    }
    public static void main(String[] args){
        getall();
    }
}
