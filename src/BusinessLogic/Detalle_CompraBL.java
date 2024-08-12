package BusinessLogic;

import java.util.List;

import DataAccess.Detalle_CompraDAO;
import DataAccess.DTO.Detalle_CompraDTO;

public class Detalle_CompraBL {

    private Detalle_CompraDTO detalle_Compra;
    private Detalle_CompraDAO detalle_CompraDAO = new Detalle_CompraDAO();

    public Detalle_CompraBL (){}

    public boolean create(Detalle_CompraDTO detalle_CompraDTO) throws Exception {
        return detalle_CompraDAO.create(detalle_CompraDTO);
    }

    public Detalle_CompraDTO readBy(Integer id) throws Exception {
        detalle_Compra = detalle_CompraDAO.readBy(id);
        return detalle_Compra;
    }

    public List<Detalle_CompraDTO> getAll() throws Exception {
        List<Detalle_CompraDTO> lst = detalle_CompraDAO.readAll();
        return lst;
    }

    public boolean update(Detalle_CompraDTO detalle_CompraDTO) throws Exception{
        return detalle_CompraDAO.update(detalle_CompraDTO);
    }

    public boolean delete (int id) throws Exception {
        return detalle_CompraDAO.delete(id);
    }
}
