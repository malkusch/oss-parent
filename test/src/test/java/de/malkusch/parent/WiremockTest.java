package de.malkusch.parent;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest(httpPort = WiremockTest.PORT)
public class WiremockTest {

    static final int PORT = 8080;

    @Test
    public void shouldMock() throws Exception {
        stubFor(get("/any").willReturn(ok("response")));

        var response = http("/any");

        verify(getRequestedFor(urlEqualTo("/any")));
        assertEquals("response", response);
    }

    private static String http(String path) throws Exception {
        var url = new URL("http://localhost:" + PORT + path);
        try (var stream = url.openStream()) {
            return new String(stream.readAllBytes());
        }
    }
}
