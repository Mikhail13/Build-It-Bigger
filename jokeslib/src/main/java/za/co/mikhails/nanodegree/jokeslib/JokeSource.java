package za.co.mikhails.nanodegree.jokeslib;

import java.util.Random;

public class JokeSource {
    private static Random random = new Random();
    private String[] jokes = {"Chuck Norris can make a class that is both abstract and final.",
            "Chuck Norris can retrieve anything from /dev/null.",
            "Chuck Norris knows the last digit of pi.",
            "Chuck Norris can compile syntax errors.",
            "Chuck Norris can unit test entire applications with a single assert."};

    public String getJoke() {
        return jokes[random.nextInt(5)];
    }
}
