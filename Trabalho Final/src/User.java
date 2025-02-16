public class User {
    private String username;
    private String cpf_cnpj;
    private String endereco;
    private String email;
    private String senha;

    User(String username, String cpf_cnpj, String endereco, String email, String senha){
        this.username = username;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;

    }

    public String getUsername() {
        return username;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
