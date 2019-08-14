
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@SpringBootApplication
@ComponentScan("com.dubbo.provider")
public class ProviderApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ProviderApplication.class, args);
		new SpringApplicationBuilder(ProviderApplication.class)
				.listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
					Environment environment = event.getEnvironment();
					int port = environment.getProperty("embedded.zookeeper.port", int.class);
					new EmbeddedZooKeeper(port, false).start();
				}).run(args);


	}

}
