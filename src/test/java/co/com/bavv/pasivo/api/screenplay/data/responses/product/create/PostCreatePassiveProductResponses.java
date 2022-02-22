package co.com.bavv.pasivo.api.screenplay.data.responses.product.create;

import static com.peterland.karate.api.screenplay.model.EnumUtils.lookupMap;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

import com.peterland.karate.api.screenplay.model.HTTPResponse;

public enum PostCreatePassiveProductResponses {
    SUCCESS("exitosa", SC_CREATED, "classpath:schemas/pasivo/create-passive-product/responses/ok.json");

    private HTTPResponse HTTPResponse;
    private final String identifier;

    PostCreatePassiveProductResponses(String identification, int statusCode, String body) {
        this.HTTPResponse = new HTTPResponse(statusCode, body);
        this.identifier = identification;
    }

    public HTTPResponse response() {
        return HTTPResponse;
    }

    public String identifier() {
        return identifier;
    }

    public static HTTPResponse identifiedWith(String identifier) {
        PostCreatePassiveProductResponses response = lookupMap(PostCreatePassiveProductResponses.class, e -> e.identifier()).apply(identifier);
        return response.HTTPResponse;
    }
}
