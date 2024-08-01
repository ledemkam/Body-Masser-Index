package techchillo.ledemkam.bmi.mapper;

import org.springframework.stereotype.Component;
import techchillo.ledemkam.bmi.dto.AccountDTO;
import techchillo.ledemkam.bmi.dto.ImcDTO;
import techchillo.ledemkam.bmi.entity.Account;
import techchillo.ledemkam.bmi.entity.Imc;

@Component
public class ImcMapper {
    AccountMapper accountMapper;

    public ImcMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Imc dtoEntity(ImcDTO input) {
        Imc outpout = new Imc();
        outpout.setWeight(input.getWeight());
        outpout.setHeight(input.getHeight());

        Account account = this.accountMapper.dtoEntity(input.getAccount());
        outpout.setAccount(account);
        return outpout;
    }

    public ImcDTO entityDto(Imc input) {
        ImcDTO outpout = new ImcDTO();
        outpout.setWeight(input.getWeight());
        outpout.setHeight(input.getHeight());

        AccountDTO account= this.accountMapper.entityDto(input.getAccount());
        outpout.setAccount(account);
        return outpout;
    }
}

