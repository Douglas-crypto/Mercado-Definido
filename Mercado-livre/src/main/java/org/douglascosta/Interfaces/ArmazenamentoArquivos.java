package org.douglascosta.Interfaces;

import java.io.File;

public interface ArmazenamentoArquivos {

    String Armazena(File file);
    String getByCaminho(String f);
    String getUrl(String id);
}
