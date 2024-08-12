package BusinessLogic;

import java.util.List;

import DataAccess.CajeroDAO;
import DataAccess.DTO.CajeroDTO;

public class CajeroBL {
    private CajeroDTO cajero;
    private CajeroDAO cajeroDAO;

    public CajeroBL (){}

    public boolean create(CajeroDTO cajeroDTO) throws Exception{
        return cajeroDAO.create(cajeroDTO);
    } 

    public CajeroDTO readBy(Integer id) throws Exception {
        cajero = cajeroDAO.readBy(id);
        return cajero;
    }

    public List<CajeroDTO> getAll() throws Exception {
        List<CajeroDTO> lst = cajeroDAO.readAll();
        return lst;
    }

    public boolean update(CajeroDTO cajeroDTO) throws Exception{
        return cajeroDAO.update(cajeroDTO);
    }

    public boolean delete (int id) throws Exception {
        return cajeroDAO.delete(id);
    }
}
