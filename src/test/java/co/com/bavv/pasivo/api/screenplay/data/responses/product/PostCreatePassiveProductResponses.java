package co.com.bavv.pasivo.api.screenplay.data.responses.product;

import static org.apache.http.HttpStatus.SC_CREATED;

import com.peterland.karate.api.screenplay.model.HTTPResponse;
import com.peterland.karate.api.screenplay.tasks.Response;

public enum PostCreatePassiveProductResponses implements Response {
    SUCCESS("exitosa", SC_CREATED,
        "classpath:schemas/pasivo/create-passive-product/responses/ok.json");

    private HTTPResponse HTTPResponse;
    private final String identifier;

    PostCreatePassiveProductResponses(String identification, int statusCode, String body) {
        this.HTTPResponse = new HTTPResponse(statusCode, body);
        this.identifier = identification;
    }

    public HTTPResponse response() {
        return HTTPResponse;
    }

    public String id() {
        return identifier;
    }

}
