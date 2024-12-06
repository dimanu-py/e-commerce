package dimanu.app.backoffice.backend.command;

import dimanu.shared.infra.cli.ConsoleCommand;

public class FakeCommand extends ConsoleCommand {
    @Override
    public void execute(String[] args) {
        System.out.println("Fake command executed");
    }
}
