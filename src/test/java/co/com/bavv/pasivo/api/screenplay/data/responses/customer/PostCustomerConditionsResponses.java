package co.com.bavv.pasivo.api.screenplay.data.responses.customer;

import static javax.servlet.http.HttpServletResponse.SC_OK;

import com.peterland.karate.api.screenplay.model.HTTPResponse;
import com.peterland.karate.api.screenplay.tasks.Response;

public enum PostCustomerConditionsResponses implements Response {
    SUCCESS("exitosa", SC_OK, "classpath:schemas/pasivo/customer-conditions/responses/ok.json");

    private com.peterland.karate.api.screenplay.model.HTTPResponse HTTPResponse;
    private final String identifier;

    PostCustomerConditionsResponses(String identification, int statusCode, String body) {
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
