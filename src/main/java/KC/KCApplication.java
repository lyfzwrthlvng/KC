package KC;

import KC.constants.EndService;
import KC.constants.ExecutionStep;
import KC.executor.Authentication;
import KC.executor.DbWrite;
import KC.resources.SearchResources;
import KC.resources.WriteResources;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class KCApplication extends Application<KCConfiguration> {

    Delegator delegator;

    public static void main(String[] args) throws Exception {
        new KCApplication().run(args);
    }

    @Override
    public void run(KCConfiguration configuration, Environment environment) {

        Injector injector = Guice.createInjector(new GuiceModule(configuration, environment));
        // Get resources through injector so we can inject dependencies in resources through guice
        environment.jersey().register(injector.getInstance(WriteResources.class));
        environment.jersey().register(injector.getInstance(SearchResources.class));

        delegator = injector.getInstance(Delegator.class);
        registerServices();
        registerExecutionSteps();
    }

    private void registerServices() {
        delegator.registerToService(EndService.WRITE_KNOWLEDGE, ExecutionStep.Authentication);
        delegator.registerToService(EndService.WRITE_KNOWLEDGE, ExecutionStep.DbWrite);
    }

    private void registerExecutionSteps() {
        delegator.registerExeuctionStep(ExecutionStep.Authentication, Authentication.class);
        delegator.registerExeuctionStep(ExecutionStep.DbWrite, DbWrite.class);
    }

}
