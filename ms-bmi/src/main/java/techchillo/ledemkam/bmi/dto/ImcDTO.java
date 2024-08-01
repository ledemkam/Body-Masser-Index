package techchillo.ledemkam.bmi.dto;
//dto stands for Data Transfer Object
//dto sert à transférer des données entre les couches de l'application
public class ImcDTO {

        private int weight;
        private int height;
        private AccountDTO account;

        public ImcDTO() {
        }

        public ImcDTO(int weight, int height, AccountDTO account) {
            this.weight = weight;
            this.height = height;
            this.account = account;
        }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }
}
