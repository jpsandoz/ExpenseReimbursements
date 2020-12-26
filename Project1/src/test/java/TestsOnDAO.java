import com.ex.webapp.DAO.ReimburseDAOImpl;
import com.ex.webapp.DAO.UserDAOImpl;
import org.junit.Test;

public class TestsOnDAO {
    @Test
    public void shouldGetAllUsers(){
        UserDAOImpl dao = new UserDAOImpl();
        System.out.println(dao.getAllUsers().toString());
    }

    @Test
    public void shouldGetUserByEmployeeId(){
        UserDAOImpl dao = new UserDAOImpl();
        System.out.println(dao.getByEmployeeId("testuser").toString());
    }

    @Test
    public void shouldGetUserByEmail(){
        UserDAOImpl dao = new UserDAOImpl();
        System.out.println(dao.getByEmail("test@gmail.com").toString());
    }

    @Test
    public void shouldGetPendingRequests(){
        ReimburseDAOImpl impl = new ReimburseDAOImpl();
        System.out.println(impl.getAllReimbursePending().toString());
    }
    @Test
    public void shouldGetPendingById(){
        ReimburseDAOImpl impl = new ReimburseDAOImpl();
        System.out.println(impl.getAllReimbursePendingByID(1).toString());
    }
    @Test
    public void shouldGetResolved(){
        ReimburseDAOImpl impl = new ReimburseDAOImpl();
        System.out.println(impl.getAllReimburseResolved());
    }
}
