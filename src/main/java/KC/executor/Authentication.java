package KC.executor;

import KC.entities.KCAccessRequest;

public class Authentication implements Node {
    // Verifies if user is authenticated for the request

    @Override
    public boolean process(KCAccessRequest request) {
        // verify if user exists
        // and is authenticated in
        //return false;
        return true;
    }

    @Override
    public boolean process() {
        // verify if user exists
        // and is authenticated in
        return false;
    }
}
