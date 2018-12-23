package KC.executor;

import KC.entities.KCAccessRequest;

import KC.constants.*;
import java.util.ArrayList;

public class Machine {

    // The machine that stitches together different components and executes any request
    ArrayList<Node> executionList = null;
    EndService service = null;
    KCAccessRequest request = null;

    public Machine(ArrayList<Node> executionList, EndService service, KCAccessRequest request) {
        this.executionList = executionList;
        this.service = service;
        this.request = request;
    }

    public void populateExecutionList(ArrayList<Node> executionList) {
        this.executionList = executionList;
    }

    public boolean execute() {
        if( this.executionList == null ) {
            return false;
        }
        for(Node executionStep : executionList) {
            if( !executionStep.process(request) ) {
                return false;
            }
        }
        return true;
    }
}