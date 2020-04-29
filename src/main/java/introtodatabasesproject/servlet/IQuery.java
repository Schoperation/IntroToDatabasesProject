package introtodatabasesproject.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface IQuery {

    /*
        Interface for all possibly queries that can be processed by the system
     */

    void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException;
}
