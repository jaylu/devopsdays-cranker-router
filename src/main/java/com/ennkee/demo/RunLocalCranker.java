package com.ennkee.demo;

import com.hsbc.cranker.mucranker.CrankerRouter;
import com.hsbc.cranker.mucranker.CrankerRouterBuilder;
import io.muserver.ContentTypes;
import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import org.json.JSONObject;

public class RunLocalCranker {

    public static void main(String[] args) {

        CrankerRouter router = CrankerRouterBuilder
                .crankerRouter()
                .start();

        MuServer registrationServer = MuServerBuilder
                .httpsServer()
                .withHttpsPort(12002)
                .addHandler(router.createRegistrationHandler())
                .addHandler(Method.GET, "/health/connectors", (muRequest, muResponse, map) -> {
                    muResponse.contentType(ContentTypes.APPLICATION_JSON);
                    muResponse.write(new JSONObject()
                            .put("services", router.collectInfo().toMap())
                            .toString());
                })
                .start();

        MuServer httpServer = MuServerBuilder
                .httpServer()
                .withHttpPort(12000)
                .addHandler(router.createHttpHandler())
                .start();

        System.out.println("router started at " + httpServer.uri() +
                ", with registration url ws" + registrationServer.uri().toString().substring(4));
    }

}
