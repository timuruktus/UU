package trelico.ru.uu.dataSources.local.repositories;

import javax.inject.Inject;

import trelico.ru.uu.dataSources.local.dao.UserDAO;
import trelico.ru.uu.dataSources.remote.BackendlessAPI;

public class LoginRepo implements LoginRepoAPI{

    private UserDAO userDAO;
    private BackendlessAPI backendlessAPI;

    @Inject
    public LoginRepo(UserDAO userDAO, BackendlessAPI backendlessAPI){
        this.userDAO = userDAO;
        this.backendlessAPI = backendlessAPI;
    }


}
