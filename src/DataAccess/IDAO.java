package DataAccess;

import java.util.List;

public interface IDAO<T>{
    
    public boolean create(T entity) throws Exception;
    public List<T> readAll() throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(Integer id) throws Exception;
    
    public T readby(Integer id) throws Exception;
}
