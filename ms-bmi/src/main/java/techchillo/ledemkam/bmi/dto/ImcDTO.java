package techchillo.ledemkam.bmi.dto;
//dto stands for Data Transfer Object

public class ImcDTO {

        private int weight;
        private int height;
        private AccountDTO  accountDTO;

        public ImcDTO() {
        }

        public ImcDTO(int weight, int height, AccountDTO accountDTO) {
            this.weight = weight;
            this.height = height;
            this.accountDTO = accountDTO;
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

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }
}
