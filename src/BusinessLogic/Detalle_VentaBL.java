package BusinessLogic;

import java.util.List;

import DataAccess.Detalle_VentaDAO;
import DataAccess.DTO.Detalle_VentaDTO;

public class Detalle_VentaBL {

    private Detalle_VentaDTO detalle_Venta;
    private Detalle_VentaDAO detalle_VentaDAO;

    public Detalle_VentaBL(){}

    public boolean create(Detalle_VentaDTO detalle_VentaDTO) throws Exception{
        return detalle_VentaDAO.create(detalle_VentaDTO);
    } 

    public Detalle_VentaDTO readBy(Integer id) throws Exception {
        detalle_Venta = detalle_VentaDAO.readBy(id);
        return detalle_Venta;
    }

    public List<Detalle_VentaDTO> getAll() throws Exception {
        List<Detalle_VentaDTO> lst = detalle_VentaDAO.readAll();
        return lst;
    }

    public boolean update(Detalle_VentaDTO detalle_VentaDTO) throws Exception{
        return detalle_VentaDAO.update(detalle_VentaDTO);
    }

    public boolean delete (int id) throws Exception {
        return detalle_VentaDAO.delete(id);
    }
}
