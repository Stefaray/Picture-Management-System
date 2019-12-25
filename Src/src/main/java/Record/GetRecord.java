package Record;

import Dao.OpRecord;
import Dao.User;
import Sql.AccessRecord;
import Sql.SqlTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/getRecordServlet")
public class GetRecord extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        List<OpRecord> allRecords = AccessRecord.findAllRecords();

        String[] records=new String[allRecords.size()];
        for(int i=0;i<allRecords.size();i++){
            records[i]=allRecords.get(i).toString();

        }
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(mapper.writeValueAsString(records));//

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
