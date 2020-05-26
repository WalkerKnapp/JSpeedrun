package com.walker.jspeedrun.api;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.runtime.Settings;
import com.walker.jspeedrun.api.games.Game;
import com.walker.jspeedrun.api.leaderboards.Leaderboard;
import com.walker.jspeedrun.api.structs.JSpeedrunData;
import com.walker.jspeedrun.api.structs.JSpeedrunResponse;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class JSpeedrun {
    private static final String API_HOST = "speedrun.com";
    private static final String API_ENDPOINT = "api";
    private static final String API_VERSION = "v1";

    private final String apiKey;

    private final OkHttpClient okHttpClient;
    private final DslJson<ThreadLocal<Class<?>>> jsonParser;

    /**
     * Creates an unauthenticated instance of a JSpeedrun object to interact anonymously with the speedrun.com API.
     */
    public JSpeedrun() {
        this(null);
    }

    /**
     * Creates an authenticated instance of a JSpeedrun object to interact using credentials with the speedrun.com API.
     * @param apiKey The API Key to authenticate future API calls with. See https://github.com/speedruncomorg/api/blob/master/authentication.md
     */
    public JSpeedrun(String apiKey) {
        this.apiKey = apiKey;

        this.okHttpClient = new OkHttpClient.Builder().build();

        this.jsonParser = new DslJson<>(Settings.<ThreadLocal<Class<?>>>withRuntime()
                .withContext(new ThreadLocal<>())
                .withJavaConverters(true)
                .includeServiceLoader());

        // Dsl-json is bad at actually configuring custom converters. Force converters to configure.
        JSpeedrunData.Converter.forceConfigure(jsonParser);
    }

    public CompletableFuture<JSpeedrunResponse<Game>> getGames() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Expect response containing JSpeedrunGame objects
                this.jsonParser.context.set(Game[].class);

                HttpUrl.Builder httpUrl = new HttpUrl.Builder()
                        .scheme("https")
                        .host(API_HOST)
                        .addPathSegment(API_ENDPOINT)
                        .addPathSegment(API_VERSION)
                        .addPathSegment("games");

                InputStream response = makeAPIRequest(httpUrl);

                return jsonParser.deserialize(JSpeedrunResponse.class, response);
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        });
    }

    public CompletableFuture<JSpeedrunResponse<Leaderboard>> getCategoryLeaderboard(String gameId, String leaderboardId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Expect response containing JSpeedrunLeaderboard object
                this.jsonParser.context.set(Leaderboard.class);

                HttpUrl.Builder httpUrl = new HttpUrl.Builder()
                        .scheme("https")
                        .host(API_HOST)
                        .addPathSegment(API_ENDPOINT)
                        .addPathSegment(API_VERSION)
                        .addPathSegment("leaderboards")
                        .addPathSegment(gameId)
                        .addPathSegment("category")
                        .addPathSegment(leaderboardId);

                InputStream response = makeAPIRequest(httpUrl);

                return jsonParser.deserialize(JSpeedrunResponse.class, response);
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        });
    }

    private InputStream makeAPIRequest(HttpUrl.Builder httpUrl) throws IOException {
        Request.Builder request = new Request.Builder()
                .url(httpUrl.build());
        if (apiKey != null) {
            request.addHeader("X-API-Key", apiKey);
        }

        Response response = okHttpClient.newCall(request.build()).execute();
        ResponseBody responseBody = response.body();

        if(responseBody == null) {
            throw new IllegalStateException("Failed to request body from speedrun.com API endpoint.");
        }

        return responseBody.byteStream();
    }
}
