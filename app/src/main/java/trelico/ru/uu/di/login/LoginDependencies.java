package trelico.ru.uu.di.login;

import trelico.ru.uu.data_sources.local.dao.UserDAO;

public interface LoginDependencies{

    UserDAO userDAO();
}
