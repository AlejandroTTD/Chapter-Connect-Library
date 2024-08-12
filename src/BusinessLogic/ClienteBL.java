package BusinessLogic;

import java.util.List;

import DataAccess.ClienteDAO;
import DataAccess.DTO.ClienteDTO;

public class ClienteBL {
    private ClienteDTO cliente;
    private ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteBL (){}

    public boolean create(ClienteDTO clienteDTO) throws Exception {
        return clienteDAO.create(clienteDTO);
    }

    public ClienteDTO readBy(Integer id) throws Exception {
        cliente = clienteDAO.readBy(id);
        return cliente;
    }


    public List<ClienteDTO> getAll() throws Exception {
        List<ClienteDTO> lst = clienteDAO.readAll();
        return lst;
    }

    public boolean update(ClienteDTO clienteDTO) throws Exception{
        return clienteDAO.update(clienteDTO);
    }

    public boolean delete (int id) throws Exception {
        return clienteDAO.delete(id);
    }

}
