package KC.executor;

import KC.entities.KCAccessRequest;

public interface Node {
    // An execution node
    //KCAccessRequest request = null;

    public boolean process(KCAccessRequest request);
    public boolean process();
}
