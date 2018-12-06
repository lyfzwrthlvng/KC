package KC.executor;

import KC.entities.KCAccessRequest;

public interface Node {
    // An execution node

    public boolean process(KCAccessRequest request);
}
