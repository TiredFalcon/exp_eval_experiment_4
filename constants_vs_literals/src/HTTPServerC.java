/**
 * Created by val on 05.12.17.
 */
public class HTTPServerC {

    /* CONSTANTS */
    private final int OK = 200;
    private final int CREATED = 201;
    private final int ACCEPTED = 202;
    private final int NO_CONTENT = 204;
    private final int BAD_REQUEST = 400;
    private final int NOT_FOUND = 404;
    private final int INTERNAL_SERVER_ERROR = 500;
    private final int DB_ERROR = -1;



    /* INSTANCE VARIABLES */
    Util.Connection connection;
    Util.Database db;


    /* CONSTRUCTOR */
    public HTTPServerC(Util.Database db) {
        this.connection = new Util.Connection();
        this.db = db;
    }


    /**
     * Get a request from the currently connected client, retrieve the requested
     * data from the db and respond to the client.
     *
     */
    public void handleRequest() {
        String request = this.connection.acceptRequest();

        if (request.equals("index.html")) {
            respondToClient(OK);
            return;
        }

        int dbResponse = this.queryDB(request);

        if (dbResponse == DB_ERROR) {
            respondToClient(INTERNAL_SERVER_ERROR);
            return;
        }

        switch (dbResponse) {
            case CREATED: {
                respondToClient(CREATED);
                break;
            }
            case NOT_FOUND: {
                respondToClient(NOT_FOUND);
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
     */
    public void respondToClient(int statusCode) {
        connection.sendResponse(statusCode);
        connection.close();
    }
}
