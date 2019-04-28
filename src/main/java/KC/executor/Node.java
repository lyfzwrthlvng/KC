package KC.executor;

import KC.entities.KCAccessRequest;
import KC.entities.NodeResult;

public interface Node {
    // An execution node
    //KCAccessRequest request = null;

    NodeResult output = new NodeResult();

    public boolean process(KCAccessRequest request);
    public boolean process();
    public NodeResult getOutput();
    public void setOutput(NodeResult result);
    String getResultNameForNode();

}
