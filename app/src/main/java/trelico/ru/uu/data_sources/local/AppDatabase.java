package trelico.ru.uu.data_sources.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import trelico.ru.uu.data_sources.local.dao.ProjectDAO;
import trelico.ru.uu.data_sources.local.dao.UserDAO;
import trelico.ru.uu.models.Project;
import trelico.ru.uu.models.User;

@Database(entities = {Project.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract ProjectDAO projectDAO();
    public abstract UserDAO userDAO();
}
