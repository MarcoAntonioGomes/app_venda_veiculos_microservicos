package br.edu.infnet.compradores;



import br.edu.infnet.compradores.exceptions.CpfInvalidoException;
import br.edu.infnet.compradores.model.domain.Comprador;
import br.edu.infnet.compradores.service.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
@Order(5)
public class CompradorTeste implements ApplicationRunner {

    @Autowired
    private CompradorService compradorService;

    @Override
    public void run(ApplicationArguments args)  {
        System.out.println("#comprador");


        String dir = "C:/Users/marco/Desktop/POS-PROJETOS/appvenda/src/main/resources/files/";
        String arq = "compradores.txt";

        try {
            try {
                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha = leitura.readLine();

                while (linha != null){

                    List<String> campos = List.of(linha.split(";"));

                    try {
                        Comprador c1 = new Comprador(campos.get(0), campos.get(1), campos.get(2));

                        compradorService.incluir(c1);
                    } catch (CpfInvalidoException e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }


                    linha = leitura.readLine();
                }


                leitura.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("[ERRO] O arquivo não existe!!!");
            } catch (IOException e) {
                System.out.println("[ERRO] Problema no fechamento do arquivo!!!");
            }


        } finally {
            System.out.println("Terminou!!!");
        }

    }
}
