package za.co.mikhails.nanodegree.jokes.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import za.co.mikhails.nanodegree.jokeslib.JokeSource;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jokes.nanodegree.mikhails.co.za",
                ownerName = "backend.jokes.nanodegree.mikhails.co.za",
                packagePath = ""
        )
)
public class MyEndpoint {
    private final JokeSource jokeSource = new JokeSource();

    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        response.setData(jokeSource.getJoke());

        return response;
    }

}
