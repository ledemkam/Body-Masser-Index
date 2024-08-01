package techchillo.ledemkam.bmi.service;

import org.springframework.stereotype.Service;
import techchillo.ledemkam.bmi.entity.Account;
import techchillo.ledemkam.bmi.repository.AccountRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountServive {


    private AccountRepository accountRepository;

    public AccountServive(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    public Account createAccount(Account account) {
        if (!account.getEmail().contains("@")){ //si l'email ne contient pas de @
            throw new IllegalCallerException("Invalid email");
        }
        Optional<Account> accountOptional = this.accountRepository.findByEmail(account.getEmail());//optional permet de verifier si un compte existe déjà dans la base de données
        if (accountOptional.isEmpty()) {//si le compte n'existe pas
            account.setCreated_at(LocalDateTime.now());//on recupere la date actuelle
             account = this.accountRepository.save(account);//on cree le compte et on le sauvegarde dans la base de données
        }else { //si le compte existe déjà
           account = accountOptional.get();//on recupere le compte
        }

        return account;
    }

}
