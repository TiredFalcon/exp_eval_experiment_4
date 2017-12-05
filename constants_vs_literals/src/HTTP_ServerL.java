/**
 * Created by val on 05.12.17.
 */
public class HTTP_ServerL {
    /* INSTANCE VARIABLES */
    Util.Client connectedClient;
    Util.Database db;


    /* CONSTRUCTOR */
    public HTTP_ServerL(Util.Client client, Util.Database db) {
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
            case 200: {
                respondToClient(200, true);
                break;
            }
            case 201: {
                respondToClient(201, true);
                break;
            }
            case 202: {
                respondToClient(202, true);
                break;
            }
            case 204: {
                respondToClient(204, true);
                break;
            }
            case 400: {
                respondToClient(400, false);
                break;
            }
            case 404: {
                respondToClient(404, false);
                break;
            }
            case 500: {
                respondToClient(500, false);
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
