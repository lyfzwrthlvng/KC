package KC.executor;

import KC.entities.KCAccessRequest;

import KC.constants.*;
import java.util.ArrayList;

public class Machine {

    // The machine that stitches together different components and executes any request
    ArrayList<Node> executionList = null;
    EndService service = null;

    public Machine(ArrayList<Node> executionList, EndService service) {
        this.executionList = executionList;
        this.service = service;
    }

    public void populateExecutionList(ArrayList<Node> executionList) {
        this.executionList = executionList;
    }

    public boolean execute() {
        if( this.executionList == null ) {
            return false;
        }
        for(Node executionStep : executionList) {
            if( !executionStep.process() ) {
                return false;
            }
        }
        return true;
    }
}