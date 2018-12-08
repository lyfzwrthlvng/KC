package KC.executor;

import KC.entities.KCAccessRequest;

public class Authentication implements Node {
    // Verifies if user is authenticated for the request

    KCAccessRequest request;

    public Authentication(KCAccessRequest request) {
        this.request =request;
    }

    @Override
    public boolean process(KCAccessRequest request) {
        // verify if user exists
        // and is authenticated in
        return false;
    }

    @Override
    public boolean process() {
        // verify if user exists
        // and is authenticated in
        return false;
    }
}
