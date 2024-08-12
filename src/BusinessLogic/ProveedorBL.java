package BusinessLogic;

import java.util.List;

import DataAccess.ProveedorDAO;
import DataAccess.DTO.ProveedorDTO;

public class ProveedorBL {
    
    private ProveedorDTO proveedor;
    private ProveedorDAO proveedorDAO;

    public ProveedorBL(){}

    public boolean create(ProveedorDTO proveedorDTO) throws Exception{
        return proveedorDAO.create(proveedorDTO);
    } 

    public ProveedorDTO readBy(Integer id) throws Exception {
        proveedor = proveedorDAO.readBy(id);
        return proveedor;
    }

    public List<ProveedorDTO> getAll() throws Exception {
        List<ProveedorDTO> lst = proveedorDAO.readAll();
        return lst;
    }

    public boolean update(ProveedorDTO proveedorDTO) throws Exception{
        return proveedorDAO.update(proveedorDTO);
    }

    public boolean delete (int id) throws Exception {
        return proveedorDAO.delete(id);
    }
}
