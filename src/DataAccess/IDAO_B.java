package DataAccess;

import java.util.List;

public interface IDAO_B <T>{
    public boolean create(T entity) throws Exception;
    public List<T> readAll() throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(String codigoB) throws Exception;
    
    public T readBy(String codigoB) throws Exception;
}
