package dimanu.app;

import dimanu.app.backoffice.backend.BackofficeBackendApplication;
import dimanu.shared.infra.cli.ConsoleCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.HashMap;

public class Starter {

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("There are not enough arguments");
        }

        String applicationName = args[0];
        String commandName = args[1];
        boolean isServerCommand = commandName.equals("server");

        ensureApplicationExist(applicationName);
        ensureCommandExist(applicationName, commandName);

        Class<?> applicationClass = applications().get(applicationName);

        SpringApplication app = new SpringApplication(applicationClass);

        if (!isServerCommand) {
            app.setWebApplicationType(WebApplicationType.NONE);
        }

        ConfigurableApplicationContext context = app.run(args);

        if (!isServerCommand) {
            ConsoleCommand command = (ConsoleCommand) context.getBean(commands().get(applicationName).get(commandName));

            command.execute(Arrays.copyOfRange(args, 2, args.length));
        }
    }

    private static void ensureApplicationExist(String applicationName) throws RuntimeException {
        if (!applications().containsKey(applicationName)) {
            throw new RuntimeException(
                    String.format(
                            "The application <%s> doesn't exist. Valids:\n- %s",
                            applicationName,
                            String.join("\n- ", applications().keySet())
                    )
            );
        }
    }

    private static void ensureCommandExist(String applicationName, String commandName) throws RuntimeException {
        if (!"server".equals(commandName) && !existCommand(applicationName, commandName)) {
            throw new RuntimeException(
                    String.format(
                            "The command <%s> for application <%s> doesn't exist. Valids (application.command):\n- api\n- %s",
                            commandName,
                            applicationName,
                            String.join("\n- ", commands().get(applicationName).keySet())
                    )
            );
        }
    }

    private static HashMap<String, Class<?>> applications() {
        HashMap<String, Class<?>> applications = new HashMap<>();

        applications.put("backoffice_backend", BackofficeBackendApplication.class);

        return applications;
    }

    private static HashMap<String, HashMap<String, Class<?>>> commands() {
        HashMap<String, HashMap<String, Class<?>>> commands = new HashMap<>();

        commands.put("backoffice_backend", BackofficeBackendApplication.commands());

        return commands;
    }

    private static Boolean existCommand(String applicationName, String commandName) {
        HashMap<String, HashMap<String, Class<?>>> commands = commands();

        return commands.containsKey(applicationName) && commands.get(applicationName).containsKey(commandName);
    }

}