package KC;

import KC.resources.SearchResources;
import KC.resources.WriteResources;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class KCApplication extends Application<KCConfiguration> {
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
}
