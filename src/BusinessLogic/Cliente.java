package BusinessLogic;

import DataAccess.ClienteDAO;
import DataAccess.DTO.ClienteDTO;
public class Cliente {
    private ClienteDTO cliente;
    private ClienteDAO cDAO = new ClienteDAO();

    public Cliente (){}

    public List<ClienteDTO> getAll() throws Exception {
        return cDAO.readAll();
    }
}
