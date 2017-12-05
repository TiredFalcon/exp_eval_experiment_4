/**
 * Created by val on 05.12.17.
 */
public class HTTP_ServerC {

    /* CONSTANTS */
    private int OK = 200;
    private int CREATED = 201;
    private int ACCEPTED = 202;
    private int NO_CONTENT = 204;
    private int BAD_REQUEST = 400;
    private int NOT_FOUND = 404;
    private int INTERNAL_SERVER_ERROR = 500;

    private boolean POSITIVE = true;
    private boolean NEGATIVE = false;


    /* INSTANCE VARIABLES */
    Util.Client connectedClient;
    Util.Database db;


    /* CONSTRUCTOR */
    public HTTP_ServerC(Util.Client client, Util.Database db) {
        this.connectedClient = client;
        this.db = db;
    }


    /**
     * Get a request from the currently connected client, retrieve the requested
     * data from the db and respond to the client.
     *
     */
    public void handleRequest() {
        String request = this.connectedClient.getRequest();

        int dbResponse = this.queryDB(request);

        switch (dbResponse) {
            case OK: {
                respondToClient(OK, true);
                break;
            }
            case CREATED: {
                respondToClient(CREATED, POSITIVE);
                break;
            }
            case ACCEPTED: {
                respondToClient(ACCEPTED, POSITIVE);
                break;
            }
            case NO_CONTENT: {
                respondToClient(NO_CONTENT, POSITIVE);
                break;
            }
            case BAD_REQUEST: {
                respondToClient(BAD_REQUEST, NEGATIVE);
                break;
            }
            case NOT_FOUND: {
                respondToClient(NOT_FOUND, NEGATIVE);
                break;
            }
            case INTERNAL_SERVER_ERROR: {
                respondToClient(INTERNAL_SERVER_ERROR, NETAGTIVE);
                break;
            }

        }
    }

    /**
     * Query the database for a given string and retrieve the data.
     *
     * @param queryString The string for which the db will be queried.
     * @return Returns the response of the query.
     */
    public int queryDB(String queryString) {
        int queryResponse = this.db.query(queryString);
        return queryResponse;
    }

    /**
     * Respond to the currently connected client.
     *
     * @param statusCode The statuscode that will be sent to the client.
     * @param accept A boolean that indicates if the request has been accepted or not.
     */
    public void respondToClient(int statusCode, boolean accept) {
        if (accept) connectedClient.acceptResponse(statusCode);
        else connectedClient.rejectResponse(statusCode);
    }
}
