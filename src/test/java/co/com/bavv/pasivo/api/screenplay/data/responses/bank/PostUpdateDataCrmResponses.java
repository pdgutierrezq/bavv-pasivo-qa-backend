package co.com.bavv.pasivo.api.screenplay.data.responses.bank;

import static org.apache.http.HttpStatus.SC_OK;

import com.peterland.karate.api.screenplay.model.HTTPResponse;
import com.peterland.karate.api.screenplay.tasks.Response;

public enum PostUpdateDataCrmResponses implements Response {
    SUCCESS("exitosa", SC_OK, "classpath:schemas/pasivo/update-data-crm/responses/ok.json");

    private HTTPResponse HTTPResponse;
    private final String identifier;

    PostUpdateDataCrmResponses(String identification, int statusCode, String body) {
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
