/**
 * Created by val on 05.12.17.
 */
public class HTTP_ServerL {

    /* INSTANCE VARIABLES */
    Util.Connection connection;
    Util.Database db;


    /* CONSTRUCTOR */
    public HTTP_ServerL(Util.Database db) {
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

        int dbResponse = this.queryDB(request);

        switch (dbResponse) {
            case 200: {
                respondToClient(200);
                break;
            }
            case 201: {
                respondToClient(201);
                break;
            }
            case 202: {
                respondToClient(202);
                break;
            }
            case 204: {
                respondToClient(204);
                break;
            }
            case 400: {
                respondToClient(400);
                break;
            }
            case 404: {
                respondToClient(404);
                break;
            }
            case 500: {
                respondToClient(500);
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
