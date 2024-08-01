package techchillo.ledemkam.bmi.service;

import org.springframework.stereotype.Service;
import techchillo.ledemkam.bmi.entity.Account;
import techchillo.ledemkam.bmi.entity.Imc;
import techchillo.ledemkam.bmi.repository.ImcRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//apres avoir creer Account(compte de l'utilisateur) avec son repository et service
// et on l utilise les parametres de Account pour stocker l'IMC

@Service
public class ImcService {

        AccountServive accountServive;
        ImcRepository imcRepository;

        public ImcService(AccountServive accountServive, ImcRepository imcRepository) {
            this.accountServive = accountServive;
            this.imcRepository = imcRepository;
        }

        public Set<Imc> search() {
            Set<Imc> imcSet = new HashSet<>();
            this.imcRepository.findAll().forEach(imcSet::add);//on recupere tous les imc et on les ajoute dans la liste,
                                                              // imcSet::add est une methode de reference,qui permet d'ajouter un element à la liste
            return imcSet;
        }


        public  double calculate(Imc imc) {

               Account account = imc.getAccount();
               account = this.accountServive.createAccount(account);
               imc.setAccount(account);
               double result = imcFromParameters(imc);
               imc.setCreated_at(LocalDateTime.now());
               this.imcRepository.save(imc);
               return result;
        }

        private double imcFromParameters(Imc imc) {

            return imc.getWeight() / Math.pow((double)imc.getHeight()/100, 2);
            }

}
