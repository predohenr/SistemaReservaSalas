package br.edu.ufca.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufca.basicas.Sala;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class telaVaziaFuncionarioController implements Initializable{
	@FXML
    private Button botaoVoltar;
    @FXML
    private Label nome1, nome2, nome3, nome4, nome5, nome6, nome7, nome8, nome9, nome10;

    @FXML
    private Label ocupada1, ocupada2, ocupada3, ocupada4, ocupada5, ocupada6, ocupada7, ocupada8, ocupada9, ocupada10;
    
    String tratamento(boolean bool) {
    	if (bool) {
    		return "Sim";
    	} else {
    		return "Não";
    	}
    }
    
    
    void mostrar(Sala sala) {
    	
    	nome1.setText(sala.salas.get(0).nome);
    	nome2.setText(sala.salas.get(1).nome);
    	nome3.setText(sala.salas.get(2).nome);
    	nome4.setText(sala.salas.get(3).nome);
    	nome5.setText(sala.salas.get(4).nome);
    	nome6.setText(sala.salas.get(5).nome);
    	nome7.setText(sala.salas.get(6).nome);
    	nome8.setText(sala.salas.get(7).nome);
    	nome9.setText(sala.salas.get(8).nome);
    	nome10.setText(sala.salas.get(9).nome);
    	ocupada1.setText(tratamento(sala.salas.get(0).ocupada));
    	ocupada2.setText(tratamento(sala.salas.get(1).ocupada));
    	ocupada3.setText(tratamento(sala.salas.get(2).ocupada));
    	ocupada4.setText(tratamento(sala.salas.get(3).ocupada));
    	ocupada5.setText(tratamento(sala.salas.get(4).ocupada));
    	ocupada6.setText(tratamento(sala.salas.get(5).ocupada));
    	ocupada7.setText(tratamento(sala.salas.get(6).ocupada));
    	ocupada8.setText(tratamento(sala.salas.get(7).ocupada));
    	ocupada9.setText(tratamento(sala.salas.get(8).ocupada));
    	ocupada10.setText(tratamento(sala.salas.get(9).ocupada));
    	
    }
    void botaoVoltar(Sala sala) {
    	botaoVoltar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sala.ser"))) {
					oos.writeObject(sala);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
		    	Parent newload;
				try {
					newload = FXMLLoader.load(getClass().getResource("TelaFuncionario.fxml"));
			    	Stage window = (Stage) botaoVoltar.getScene().getWindow();
			    	window.setScene(new Scene(newload));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		
    	});
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Sala sala = new Sala();
		try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("sala.ser"))) {
			sala = (Sala) oos.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mostrar(sala);
		botaoVoltar(sala);
	}

}