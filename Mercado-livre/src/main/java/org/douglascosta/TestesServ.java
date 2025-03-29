package org.douglascosta;

import org.douglascosta.database.ConnectionDB;
import org.douglascosta.servicos.ServicoVendas;

public class TestesServ {
    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();

        connectionDB.getConnection();

        ServicoVendas servicoVendas = new ServicoVendas();

        servicoVendas.listarVendas();

    }
}

