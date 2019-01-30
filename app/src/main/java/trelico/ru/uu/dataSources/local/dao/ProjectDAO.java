package trelico.ru.uu.dataSources.local.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Single;
import trelico.ru.uu.models.Project;

@Dao
public interface ProjectDAO {

    @Query("SELECT * FROM " + Project.TABLE_NAME)
    Single<List<Project>> getAllProjects();

    @Query("SELECT COUNT(*) FROM " + Project.TABLE_NAME)
    int projectsCount();

    @Query("SELECT * FROM " + Project.TABLE_NAME + " LIMIT :count OFFSET :offset")
    Single<List<Project>> getProjects(int offset, int count);

    @Query("SELECT * FROM " + Project.TABLE_NAME + " WHERE id = :id")
    Single<Project> getProjectById(long id);

    @Query("DELETE FROM " + Project.TABLE_NAME)
    void deleteAllProjects();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProject(Project project);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProjectList(List<Project> projects);

    @Update
    void updateProject(Project project);

    @Update
    void updateProjectList(List<Project> projects);

    @Delete
    void deleteProject(Project project);

    @Delete
    void deleteProjectList(List<Project> projects);

}
