public class User {
    private final int id;
    private final String username;
    private String cpf_cnpj;
    private String endereco;
    private String email;
    private String senha;

    User(int id, String username, String cpf_cnpj, String endereco, String email, String senha) {
        this.id = id;
        this.username = username;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
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
