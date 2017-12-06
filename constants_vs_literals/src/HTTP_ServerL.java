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

        if (request.equals("index.html")) {
            respondToClient(200);
            return;
        }

        int dbResponse = this.queryDB(request);

        if (dbResponse == -1) {
            respondToClient(500);
            return;
        }

        switch (dbResponse) {
            case 201: {
                respondToClient(201);
                break;
            }
            case 404: {
                respondToClient(404);
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
