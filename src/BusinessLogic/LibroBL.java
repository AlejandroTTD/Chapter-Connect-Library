package BusinessLogic;

import java.util.List;

import DataAccess.LibroDAO;
import DataAccess.DTO.LibroDTO;

public class LibroBL {
    private LibroDTO libro;
    private LibroDAO libroDAO;

    public LibroBL(){
        libroDAO = new LibroDAO();
    }

    public boolean create(LibroDTO libroDTO) throws Exception{
        return libroDAO.create(libroDTO);
    }

    public LibroDTO readBy(String codigoB) throws Exception {
        libro = libroDAO.readBy(codigoB);
        return libro;
    }

    public List<LibroDTO> getAll() throws Exception {
        List<LibroDTO> lst = libroDAO.readAll();
        return lst;
    }

    public boolean update(LibroDTO libroDTO) throws Exception{
        return libroDAO.update(libroDTO);
    }

    public boolean delete (String codigoB) throws Exception {
        return libroDAO.delete(codigoB);
    }
}
