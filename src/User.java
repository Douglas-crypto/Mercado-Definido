class User {
    private final int id;
    private final String username;
    private final String cpfCnpj;
    private String endereco;
    private String email;
    private String password;

    public User(int id, String username, String cpfCnpj, String endereco, String email, String password) {
        this.id = id;
        this.username = username;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return username;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void exibirInformacao() {
        System.out.println("ID: " + getId() +
                "Nome: " + getUser() +
                "CPF/CNPJ: " + getCpfCnpj() +
                "Endereço: " + getEndereco() +
                "Email: " + getEmail() +
                "Password: " + getPassword());
    }
}