package co.com.bavv.pasivo.api.screenplay.data.responses.user;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.apache.http.HttpStatus.SC_CREATED;

import com.peterland.karate.api.screenplay.model.HTTPResponse;
import com.peterland.karate.api.screenplay.tasks.Response;

public enum PostUserIdentityResponses implements Response {
    SUCCESS_VALIDATE("de validacion exitosa", SC_OK,
        "classpath:schemas/pasivo/user-identity/responses/validate.json"),
    SUCCESS_GENERATE("de generacion exitosa", SC_CREATED,
        "classpath:schemas/pasivo/user-identity/responses/generate.json");

    private HTTPResponse HTTPResponse;
    private final String identifier;

    PostUserIdentityResponses(String identification, int statusCode, String body) {
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
