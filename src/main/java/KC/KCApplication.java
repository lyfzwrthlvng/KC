package KC;

import KC.constants.EndService;
import KC.constants.ExecutionStep;
import KC.executor.Authentication;
import KC.executor.DbWrite;
import KC.resources.SearchResources;
import KC.resources.WriteResources;
import com.google.inject.Inject;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class KCApplication extends Application<KCConfiguration> {

    @Inject
    Delegator delegator;

    public static void main(String[] args) throws Exception {
        new KCApplication().run(args);
    }

    @Override
    public void run(KCConfiguration configuration, Environment environment) {
        // let's see what we gotta do here
        // register resources, do some bookkeeping as per configuration etc
        environment.jersey().register(new WriteResources(configuration));
        environment.jersey().register(new SearchResources(configuration));

    }

    private void registerServices() {
        delegator.registerToService(EndService.WRITE_KNOWLEDGE, ExecutionStep.Authentication);

    }

    private void registerExecutionSteps() {
        delegator.registerExeuctionStep(ExecutionStep.Authentication, Authentication.class);
        delegator.registerExeuctionStep(ExecutionStep.DbWrite, DbWrite.class);
    }

}
