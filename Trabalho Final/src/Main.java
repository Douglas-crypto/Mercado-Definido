public class Main {
    public static void main(String[] args) {

        Cadastros cadastros = new Cadastros();

        User usuario1 = new User("João Silva", "12345678901",
                "Rua A 123", "joao.silva@email.com", "senha123");

        cadastros.CadastroUser(usuario1);

        System.out.println(usuario1.getUsername());
        System.out.println(usuario1.getCpf_cnpj());
        System.out.println(usuario1.getEndereco());
        System.out.println(usuario1.getEmail());
        System.out.println(usuario1.getSenha());

        System.out.println();
    }
}
