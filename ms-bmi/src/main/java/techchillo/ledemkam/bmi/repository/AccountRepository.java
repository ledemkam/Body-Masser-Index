package techchillo.ledemkam.bmi.repository;

import org.springframework.data.repository.CrudRepository;
import techchillo.ledemkam.bmi.entity.Account;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    //CrudRepository est une interface qui permet de faire des opérations CRUD (Create, Read, Update, Delete) sur une entité


    Optional<Account> findByEmail(String email);//cette méthode permet de chercher un compte par son email dans la base de données
    //elle permet de verifier si un compte existe déjà dans la base de données
}