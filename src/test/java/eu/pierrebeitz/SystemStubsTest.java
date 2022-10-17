package eu.pierrebeitz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SystemStubsExtension.class)
public class SystemStubsTest {

    @SystemStub
    EnvironmentVariables environmentVariables;

    @Test
    void environmentVariableInFieldShouldBeSet() {
        environmentVariables.set("FOO", "BAR");
        assertEquals("BAR", System.getenv("FOO"));
    }

    @Test
    void environmentVariableInMethodParameterShouldBeSet(EnvironmentVariables env) {
        env.set("FOO1", "BAR1");
        assertEquals("BAR1", System.getenv("FOO1"));
    }
}
