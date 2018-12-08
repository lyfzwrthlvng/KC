package KC.constants;

public class Common {
    private static Common ourInstance = new Common();

    public static Common getInstance() {
        return ourInstance;
    }


    private Common() {
    }
}
