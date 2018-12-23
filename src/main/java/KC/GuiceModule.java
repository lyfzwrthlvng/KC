package KC;

import KC.constants.EndService;
import KC.executor.Authentication;
import KC.executor.Machine;
import KC.executor.Node;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import io.dropwizard.setup.Environment;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class GuiceModule extends AbstractModule {

    KCConfiguration configuration;
    Environment environment;

    GuiceModule(@NotNull KCConfiguration configuration, @NotNull Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        ArrayList<Node> executionList = new ArrayList<>();
        //executionList.add(new Authentication());
        //bind(Machine.class).annotatedWith(Names.named(EndService.WRITE_KNOWLEDGE.toString())).toInstance(new Machine());
        // TODO verify performance implications of this
        bind(Delegator.class).toInstance(new Delegator());
        bind(KCConfiguration.class).toInstance(configuration);
        bind(Environment.class).toInstance(environment);
    }
}
