package trelico.ru.uu.data_sources.local.repositories;

import javax.inject.Inject;

import trelico.ru.uu.data_sources.local.dao.UserDAO;
import trelico.ru.uu.data_sources.remote.BackendlessAPI;

public class LoginRepo implements LoginRepoAPI{

    private UserDAO userDAO;
    private BackendlessAPI backendlessAPI;

    @Inject
    public LoginRepo(UserDAO userDAO, BackendlessAPI backendlessAPI){
        this.userDAO = userDAO;
        this.backendlessAPI = backendlessAPI;
    }


}
