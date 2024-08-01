package techchillo.ledemkam.bmi.mapper;

import org.springframework.stereotype.Component;
import techchillo.ledemkam.bmi.dto.AccountDTO;
import techchillo.ledemkam.bmi.entity.Account;

@Component //afin de pouvoir injecter cette classe dans d'autres classes

//mapper sert à convertir un objet de type AccountDTO en un objet de type Account, et vice versa
//mapper servira a transferer des données entre les couches de l'application(c est dire entre les classes)
public class AccountMapper {
    public Account dtoEntity(AccountDTO input) {
        Account outpout = new Account();
        outpout.setName(input.getName());
        outpout.setEmail(input.getEmail());
        return outpout;
    }

    public AccountDTO entityDto(Account input) {
        AccountDTO outpout = new AccountDTO();
        outpout.setName(input.getName());
        outpout.setEmail(input.getEmail());
        return outpout;
    }
}
