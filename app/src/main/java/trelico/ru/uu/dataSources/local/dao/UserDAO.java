package trelico.ru.uu.dataSources.local.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Single;
import trelico.ru.uu.models.User;

@Dao
public interface UserDAO {


    @Query("SELECT * FROM " + User.TABLE_NAME)
    Single<List<User>> getAllUsers();

    @Query("SELECT COUNT(*) FROM " + User.TABLE_NAME)
    int usersCount();

    @Query("SELECT * FROM " + User.TABLE_NAME +" WHERE email = :email")
    Single<User> getUserById(String email);

    @Query("SELECT * FROM " + User.TABLE_NAME + " LIMIT :count OFFSET :offset")
    Single<List<User>> getUsers(int offset, int count);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserList(List<User> users);

    @Update
    int updateUser(User user);

    @Update
    int updateUserList(List<User> users);

    @Delete
    void deleteUser(User user);

    @Delete
    void deleteUserList(List<User> users);
}
