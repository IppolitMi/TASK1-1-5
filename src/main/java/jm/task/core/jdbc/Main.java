package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Рокки", "Бальбо", (byte) 20);
        userDaoHibernate.saveUser("Кик", "Бутовски", (byte) 25);
        userDaoHibernate.saveUser("Дональд", "Трамп", (byte) 31);
        userDaoHibernate.saveUser("Мухаммед", "Али", (byte) 38);
        List<User> printList = userDaoHibernate.getAllUsers();
        printList.forEach(System.out::println);
        userDaoHibernate.removeUserById(1);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
    }
}