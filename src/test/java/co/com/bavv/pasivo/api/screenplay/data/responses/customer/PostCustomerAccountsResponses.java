package co.com.bavv.pasivo.api.screenplay.data.responses.customer;

import static org.apache.http.HttpStatus.SC_OK;

import com.peterland.karate.api.screenplay.tasks.Response;
import com.peterland.karate.api.screenplay.model.HTTPResponse;

public enum PostCustomerAccountsResponses implements Response {
    SUCCESS("exitosa", SC_OK, "classpath:schemas/pasivo/customet-accounts/responses/ok.json");

    private HTTPResponse HTTPResponse;
    private final String identifier;

    PostCustomerAccountsResponses(String identification, int statusCode, String body) {
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
