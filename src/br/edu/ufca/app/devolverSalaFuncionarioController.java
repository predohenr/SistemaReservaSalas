package br.edu.ufca.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.edu.ufca.basicas.Sala;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class devolverSalaFuncionarioController implements Initializable{

    @FXML
    private ComboBox<String> salasAlugadas;
    @FXML
    private Button botaoDevolver;
    @FXML
    private Button botaoVoltar;
    
    private ArrayList<String> salasalug = new ArrayList<>();
    private ObservableList<String> obssala;
    
    void botaoDevolver(Sala sala) {
    	botaoDevolver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				String comboboxvalue = salasAlugadas.getSelectionModel().getSelectedItem().split(" ")[1];
				int salavalor = ((Integer.parseInt(comboboxvalue)));
				sala.DevolverSalaInt(salavalor);
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
    
    void carregarSalas(Sala a) {
    	for (int i=0; i<a.numsalas;i++) {
    		if(a.salas.get(i).ocupada) {
    			salasalug.add(a.salas.get(i).nome);
    		}
    	}
    	obssala = FXCollections.observableArrayList(salasalug);
    	salasAlugadas.setItems(obssala);
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
    	//sala.mostrarSalas();
		carregarSalas(sala);
		botaoDevolver(sala);
		botaoVoltar(sala);
	}

}
