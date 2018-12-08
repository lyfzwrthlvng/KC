package KC;

import KC.constants.EndService;
import KC.constants.ExecutionStep;
import KC.executor.Machine;
import KC.executor.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class Delegator {

    // Finds+Instantiates the machine and begins execution
    private HashMap<EndService, ArrayList<ExecutionStep>> services = null;
    private HashMap<ExecutionStep, Class<?>> executionMap = null;

    Delegator() {

    }

    public void registerExeuctionStep(ExecutionStep step, Class<?> clazz) {
        executionMap.put(step, clazz);
    }

    public void registerToService(EndService service, ExecutionStep step) {
        if(services.containsKey(service)) {
            services.get(service).add(step);
        } else {
            ArrayList<ExecutionStep> list = new ArrayList<ExecutionStep>();
            list.add(step);
            services.put(service, list);
        }
    }

    public Machine getMachine(EndService service) throws IllegalAccessException, InstantiationException {
        if(!services.containsKey(service)) {
            return null;
        }
        ArrayList<Node> executionList = new ArrayList<>();
        for(ExecutionStep step : services.get(service)) {
            Class clazz = executionMap.get(step);
            executionList.add((Node)clazz.newInstance()); // create new instance here, use injector?!
        }
        Machine machine = new Machine(executionList, service);
        return machine;
    }

    public HashMap<EndService, ArrayList<ExecutionStep>> getServices() {
        return services;
    }

    public void setServices(HashMap<EndService, ArrayList<ExecutionStep>> services) {
        this.services = services;
    }

}
