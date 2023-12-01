package com.example.proyectofinal;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.*;

public class HelloController {

    //Variable para checar si se ha inicializado

    //Variables para cambiar de escena
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Stage primaryStage;


    //Variables para el restaurante
    private static Restaurante restaurante;


    //Variable para almacenar mis clientes, ya que pueden existir sin necesidad de un restaurante
    private static Map<String, Cliente> clientes = new HashMap<>();

    private static List<Repartidor> repartidores = new ArrayList<>();


    //              Datos Restaurante

    //Variable para mostrar informacion de restaurantes
    //al actualizar informacion
    @FXML
    private TextArea datosRestaurante = new TextArea();


    //Variables para que el usuario ingrese datos del restaurante
    @FXML
    private TextField nombreRestaurante;
    @FXML
    private TextField ubicacionRestaurante;
    @FXML
    private TextField calificacionRestaurante;


    //              Menu

    @FXML
    private ListView<String> RecetasListView= new ListView<>();
    @FXML
    private TextArea textAreaMenu= new TextArea();







    //-----Registro Usuarios-------------

    //Variables para que el usuario se registre/ingrese

    @FXML
    private TextField nombreCliente;
    @FXML
    private TextField domicilioCliente;
    @FXML
    private TextField metodoPago;
    @FXML
    private TextField telefonoCliente;
    @FXML
    private Label clientLabel;

    //Botones de la interfaz del registro de clientes
    @FXML
    private Button registrarCliente = new Button();
    @FXML
    private Button ingresarCliente = new Button();

//    @FXML private Button botonPrueba= new Button();


    //              Ordenes


    //Para que los clientes puedan visualizar los platillos
    private ObservableList<Receta> list;

    @FXML
    private ListView<Receta> elegirPedidoListView=new ListView<>();

    @FXML
    private ListView<Receta> pedidoListView1 = new ListView<>();

    @FXML
    private ListView<String> ticketListView=new ListView<>();

    //Label por si no hay platillos registrados

    @FXML
    private Label label1_registrarPedido = new Label();


    //                      Repartidores


    @FXML
    private TextField registrarRepartidoresTextField1;
    @FXML
    private TextField registrarRepartidoresTextField2;
    @FXML
    private TextField registrarRepartidoresTextField3;
    @FXML
    private TextField registrarRepartidoresTextField4;

    @FXML
    private Label registrarRepartidoresLabel = new Label();

    @FXML
    private Button registrarRepartidoresButton = new Button();


    //          Platillos
    @FXML
    private ComboBox<String> opcionesPlatillos = new ComboBox<>();


    //              Comida

    @FXML
    private TextField costoComida=new TextField();
    @FXML
    private TextField nombreComida=new TextField();
    @FXML
    private TextField origenComida=new TextField();

    @FXML
    private Button buttonComida = new Button();
    @FXML
    private Label registrarComidaLabel = new Label();

    //              Bebida

    @FXML
    private TextField nombreBebida=new TextField();
    @FXML
    private TextField alcholicaBebida=new TextField();
    @FXML
    private TextField cantidadBebida=new TextField();
    @FXML
    private TextField precioBebida=new TextField();

    @FXML
    private Button buttonBebida= new Button();
    @FXML
    private Label registrarBebidaLabel = new Label();


    //              Postre

    @FXML
    private TextField nombrePostre=new TextField();
    @FXML
    private TextField saborPostre=new TextField();
    @FXML
    private TextField numR=new TextField();
    @FXML
    private TextField caloriasPostre=new TextField();

    @FXML
    private Button buttonPostre= new Button();
    @FXML
    private Label registrarPostreLabel = new Label();











    //Metodos para cambiar de escena

    public void test() {
        System.out.println("asdasdsd");
    }


    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainWindow.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();


    }

    public void switchToScene2(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToSceneRegistrarCliente(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrarCliente.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();


    }


    public void switchToScene3(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrarPedido.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene4(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrarPlatillo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene5(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrarDatosRestaurante.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene6(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrarRepartidores.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void switchBetweenRecetas(ActionEvent event) throws IOException {
        String src;
        switch (this.opcionesPlatillos.getValue().toLowerCase()) {
            case "comida" -> {
                src = "RegistrarComida.fxml";
            }
            case "bebida" -> {
                src = "RegistrarBebida.fxml";
            }
            case "postre" -> {
                src = "RegistrarPostre.fxml";

            }
            default -> {
                src = "MainWindow.fxml";
            }
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(src));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    //Metodo para salir del programa

    public void quitProgram() {
        Platform.exit();
    }


    //Metodo para mostrar un mensaje al actualizar informacion
    public void mensajeRegistrarRestaurante() {
        if (restaurante == null) {
            System.out.println(datosRestaurante);
            datosRestaurante.setText("""
                    No se ha registrado un restaurante
                    favor de registrar uno.
                    """);
        } else {
            datosRestaurante.setText(restaurante.toString());

        }


    }





    //Metodo para actualizar informacion
    public void actualizarRestaurante() {
        String nombre = nombreRestaurante.getText();
        String ubicacion = ubicacionRestaurante.getText();
        double num;

        if (isDouble(calificacionRestaurante.getText())) {
            num = Double.parseDouble(calificacionRestaurante.getText());

            if (restaurante == null) {
                restaurante = new Restaurante(nombre, ubicacion, num, new ArrayList<Pedido>(), new ArrayList<Receta>());
                restaurante.setClientes(clientes);
            } else {
                restaurante.setCalificacion(num);
                restaurante.setNombre(nombre);
                restaurante.setUbicacion(ubicacion);
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("restaurantes.txt"));

                writer.write("""
                        %s
                        %s
                        %f
                        """.formatted(restaurante.getNombre(), restaurante.getUbicacion(), restaurante.getCalificacion()));
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            mensajeRegistrarRestaurante();

        } else {
            datosRestaurante.setText("Calificacion no es un numero, favor de ingresar un numero");

        }


    }

    public void mostrarMenu(){
        String text="";

            for(Receta receta: restaurante.getRecetas()){
                if(receta instanceof Comida && RecetasListView.getSelectionModel().getSelectedItem().toLowerCase().equals("comida")){
                    text+=receta.toString();
                }

                if(receta instanceof Bebida && RecetasListView.getSelectionModel().getSelectedItem().toLowerCase().equals("bebida")){
                    text+=receta.toString();
                }

                if(receta instanceof Postre && RecetasListView.getSelectionModel().getSelectedItem().toLowerCase().equals("postres")){
                    text+=receta.toString();
                }


            }
            textAreaMenu.setText(text);
            text="";

    }


    public void elegirPlatillo(){
        ArrayList<Receta> tempRecetas= new ArrayList<>();
        for(Receta receta: restaurante.getRecetas()){
            if(receta instanceof Comida && RecetasListView.getSelectionModel().getSelectedItem().toLowerCase().equals("comida")){
                tempRecetas.add(receta);
            }

            if(receta instanceof Bebida && RecetasListView.getSelectionModel().getSelectedItem().toLowerCase().equals("bebida")){
                tempRecetas.add(receta);

            }

            if(receta instanceof Postre && RecetasListView.getSelectionModel().getSelectedItem().toLowerCase().equals("postres")){
                tempRecetas.add(receta);

            }

            elegirPedidoListView.setItems(FXCollections.observableArrayList(tempRecetas));
        }

    }



    public void agregarPlatillo(){
        restaurante.getPedidos().get(restaurante.getPedidos().size()-1).agregarPlatillo(elegirPedidoListView.getSelectionModel().getSelectedItem());
    }





    public void pagar(ActionEvent event) throws Exception{
        ArrayList<String> ticket=new ArrayList<>();
        double total=0;

                ticket.add(restaurante.getPedidos().get(restaurante.getPedidos().size()-1).getRepartidor().toString());
        for(Receta receta: restaurante.getPedidos().get(restaurante.getPedidos().size()-1).getCantPorPlatillo().keySet()){
            ticket.add(receta.toString()+" Amount: "+restaurante.getPedidos().get(restaurante.getPedidos().size()-1).getCantPorPlatillo().get(receta));

                if(receta instanceof Comida){
                    Comida comida= (Comida)receta;
                    total+=restaurante.getPedidos().get(restaurante.getPedidos().size()-1).getCantPorPlatillo().get(receta)*comida.getCosto();
                }
                if(receta instanceof Bebida){
                    Bebida bebida= (Bebida)receta;
                    total+=restaurante.getPedidos().get(restaurante.getPedidos().size()-1).getCantPorPlatillo().get(receta)*bebida.getPrecio();
                }

                if(receta instanceof Postre){
                    Postre postre= (Postre)receta;
                    total+=restaurante.getPedidos().get(restaurante.getPedidos().size()-1).getCantPorPlatillo().get(receta)*100;
                }

        }
        ticket.add("Total: %f".formatted(total));
        ticketListView.setItems(FXCollections.observableArrayList(ticket));

        ticketListView.setItems(FXCollections.observableArrayList(ticket));

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(xd -> {
            try {
                switchToStartScene();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        delay.play();



    }

    public void switchToStartScene() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }












    //Metodo para checar si expression es digito
    public static boolean isDouble(String expression) {
        try {
            Double.parseDouble(expression);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    //Metodo para registrar a un cliente

    public void registrarDatosCliente(ActionEvent event) throws IOException {

        if (clientes.isEmpty() || (!clientes.containsKey(new String(telefonoCliente.getText())))) {
            Cliente cliente = new Cliente(nombreCliente.getText(),
                    domicilioCliente.getText(),
                    metodoPago.getText());

            cliente.setTelefono(telefonoCliente.getText());
            clientes.put(new String(cliente.telefono), cliente);

            if (restaurante != null) {
                restaurante.addCliente(cliente);
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt"));
                writer.write("""
                        %s,%s,%s,%s
                        """.formatted(cliente.getNombre(), cliente.getDomicilio(), cliente.getMetodoPago(), cliente.getTelefono()));

                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrarPedido.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();


    }


    public void registrarDatosComida(ActionEvent event) throws IOException {
        if (restaurante != null) {

                Comida comida = new Comida(Double.parseDouble(costoComida.getText()), nombreComida.getText(), origenComida.getText());

                restaurante.agregarReceta(comida);

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("recetas.txt", true));
                    writer.write("""
                            c,%f,%s,%s
                            """.formatted(comida.getCosto(), comida.getNombre(), comida.getOrigen()));

                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            costoComida.clear();
            nombreComida.clear();
            origenComida.clear();

        }
    }


    public void registrarDatosBebida(ActionEvent event) throws IOException {
        if (restaurante != null) {
                boolean isAlcholic;
                if(alcholicaBebida.getText().toLowerCase()=="si"){
                    isAlcholic=true;
                }else{
                    isAlcholic=false;
                }
                Bebida bebida = new Bebida(nombreBebida.getText(),isAlcholic,Double.parseDouble(cantidadBebida.getText()),Double.parseDouble(precioBebida.getText()));

                restaurante.agregarReceta(bebida);

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("recetas.txt", true));
                    writer.write("""
                            b,%s,%s,%f,%f
                            """.formatted(bebida.getNombre(),bebida.isAlcholica(),bebida.getCantidad(),bebida.getPrecio()));

                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            nombreBebida.clear();
            alcholicaBebida.clear();
            cantidadBebida.clear();
            precioBebida.clear();
    }



    public void registrarDatosPostre(ActionEvent event) throws IOException {

                Postre postre= new Postre(nombrePostre.getText(), saborPostre.getText(), Integer.parseInt(numR.getText()),Double.parseDouble(caloriasPostre.getText()));

                restaurante.agregarReceta(postre);

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("recetas.txt", true));
                    writer.write("""
                            p,%s,%s,%d,%f
                            """.formatted(postre.getName(),postre.getSabor(),postre.getNumRebanadas(),postre.getCalorias()));

                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }


            nombrePostre.clear();
            saborPostre.clear();
            numR.clear();
            caloriasPostre.clear();

    }






    public void ingresarCliente(ActionEvent event) throws IOException {
        if (telefonoCliente.getText().length() != 10) {
            clientLabel.setText("Telefono invalido");
            ingresarCliente.setDisable(true);
            return;
        }

        if (!restaurante.getClientes().containsKey(new String(telefonoCliente.getText()))) {
            ingresarCliente.setDisable(true);
            return;
        }
        Random random= new Random();
        restaurante.agregarPedido(new Pedido(clientes.get(telefonoCliente.getText()),repartidores.get(random.nextInt(repartidores.size()))));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrarPedido.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();


    }


    //Metodo para checar el input del usuario y acticar los botones
    public void checkInputRegistroCliente() {
        if (restaurante.getClientes().containsKey(new String(telefonoCliente.getText()))) {
            clientLabel.setText("Cliente ya esta regisrado, por favor ingrese");
            ingresarCliente.setDisable(false);
            return;
        }else{
            ingresarCliente.setDisable(true);
        }
        if (!metodoPago.getText().toLowerCase().equals("efectivo") && !metodoPago.getText().toLowerCase().equals("tarjeta")) {
            clientLabel.setText("Metodo de pago invalido");
            registrarCliente.setDisable(true);
            return;
        } else {
            clientLabel.setText("");
        }

        if (telefonoCliente.getText().length() != 10) {
            clientLabel.setText("Telefono invalido");
            registrarCliente.setDisable(true);
            ingresarCliente.setDisable(true);
            return;
        } else {
            clientLabel.setText("");
        }

        if (nombreCliente.getText().isEmpty()) {
            clientLabel.setText("Nombre invalido");
            registrarCliente.setDisable(true);
            return;
        } else {
            clientLabel.setText("");
        }

        if (domicilioCliente.getText().isEmpty()) {
            clientLabel.setText("Domicilio invalido");
            registrarCliente.setDisable(true);
            return;
        } else {
            clientLabel.setText("");
        }


        registrarCliente.setDisable(false);

    }





    public void checkInputRegistroRepartidores() {
        if (this.registrarRepartidoresTextField1.getText().isEmpty() ||
                this.registrarRepartidoresTextField2.getText().isEmpty() ||
                this.registrarRepartidoresTextField3.getText().isEmpty() ||
                this.registrarRepartidoresTextField4.getText().isEmpty()) {
            this.registrarRepartidoresLabel.setText("One of the fields is empty please fill it");
            registrarRepartidoresButton.setDisable(true);
        } else {

            this.registrarRepartidoresLabel.setText("");

            if (isDouble(registrarRepartidoresTextField3.getText())
                    && isDouble(registrarRepartidoresTextField4.getText())) {
                this.registrarRepartidoresLabel.setText("");

                if (restaurante == null) {
                    this.registrarRepartidoresLabel.setText("No hay un restaurante registrado, favor de registrar uno");
                    registrarRepartidoresButton.setDisable(true);
                } else {

                    registrarRepartidoresButton.setDisable(false);
                }

            } else {
                this.registrarRepartidoresLabel.setText("Algunos de los campos no son validos");
                registrarRepartidoresButton.setDisable(true);
            }


        }
    }


    public void checkInputRegistroComida() {
        if (this.costoComida.getText().isEmpty() ||
                this.origenComida.getText().isEmpty() ||
                this.nombreComida.getText().isEmpty()) {
            this.registrarComidaLabel.setText("One of the fields is empty please fill it");
            buttonComida.setDisable(true);
        } else {
            if (!isDouble(this.costoComida.getText())) {
                this.registrarComidaLabel.setText("Costo no es valido");
                buttonComida.setDisable(true);

            } else {
                this.registrarComidaLabel.setText("");
                if (restaurante == null) {
                    this.registrarComidaLabel.setText("No hay un restaurante registrado, favor de registrar uno");
                    buttonComida.setDisable(true);

                } else {

                    buttonComida.setDisable(false);
                }
            }


        }


    }

    public void checkInputRegistroBebida() {
        if (this.nombreBebida.getText().isEmpty() ||
                this.alcholicaBebida.getText().isEmpty() ||
                this.cantidadBebida.getText().isEmpty() ||
                this.precioBebida.getText().isEmpty()) {

            this.registrarBebidaLabel.setText("One of the fields is empty please fill it");
            buttonBebida.setDisable(true);
            return;
        }

        if (!isDouble(this.cantidadBebida.getText()) ) {
                this.registrarBebidaLabel.setText("Cantidad no es valida");
                buttonBebida.setDisable(true);
                return;
            }
        if(!isDouble(this.precioBebida.getText())){
                this.registrarBebidaLabel.setText("Precio no es valido");
                buttonBebida.setDisable(true);
                return;
                }

        if (restaurante == null) {
            this.registrarBebidaLabel.setText("No hay un restaurante registrado, favor de registrar uno");
            buttonBebida.setDisable(true);
            return;
                    }
        this.registrarBebidaLabel.setText("");
        buttonBebida.setDisable(false);

    }









    public void checkInputRegistroPostre() {


        if (this.nombrePostre.getText().isEmpty() ||
            this.saborPostre.getText().isEmpty() ||
                this.numR.getText().isEmpty() ||
                this.caloriasPostre.getText().isEmpty()) {

            this.registrarPostreLabel.setText("One of the fields is empty please fill it");
            buttonPostre.setDisable(true);
            return;
        }
        if (!isDouble(this.caloriasPostre.getText())) {
            this.registrarPostreLabel.setText("Calorias no validas");
            buttonPostre.setDisable(true);
            return;

        }
        if (!isInteger(this.numR.getText())){
            this.registrarPostreLabel.setText("Cantidad de Rebanadas no valida");
            buttonPostre.setDisable(true);
            return;
        }
        if (restaurante == null) {
            this.registrarPostreLabel.setText("No hay un restaurante registrado, favor de registrar uno");
            buttonPostre.setDisable(true);
            return;
        }
        this.registrarPostreLabel.setText("");
        buttonPostre.setDisable(false);
    }











    public void agregarRepartidores() {


        Repartidor repartidor = new Repartidor(registrarRepartidoresTextField1.getText(),
                registrarRepartidoresTextField2.getText(),
                Double.parseDouble(registrarRepartidoresTextField3.getText()),
                Double.parseDouble(registrarRepartidoresTextField4.getText()));

        repartidores.add(repartidor);

        registrarRepartidoresTextField1.clear();
        registrarRepartidoresTextField2.clear();
        registrarRepartidoresTextField3.clear();
        registrarRepartidoresTextField4.clear();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("repartidores.txt", true));
            writer.write("""
                    %s,%s,%f,%f 
                    """.formatted(repartidor.getNombre(), repartidor.getMedioTransporte(), repartidor.getTiempoEstimadoEntrega(), repartidor.getScoreEficiencia()));

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void showMenuClientes() {
        if (this.list.isEmpty()) {
            this.label1_registrarPedido.setText("Aun no hay platillos registrados");
        }
    }


    public void initialize() {

        //Se deshabilitan todos los botones


        primaryStage=HelloApplication.primaryStage;
        registrarCliente.setDisable(true);
        ingresarCliente.setDisable(true);
        registrarRepartidoresButton.setDisable(true);
        buttonComida.setDisable(true);
        buttonBebida.setDisable(true);
        buttonPostre.setDisable(true);


        if (restaurante == null) {
            System.out.println("Not initialized");

        } else {
            pedidoListView1.setItems(FXCollections.observableArrayList(restaurante.getRecetas()));
            System.out.println("Initialized");
            return;
        }

        if (this.list == null || this.list.isEmpty()) {
            this.label1_registrarPedido.setText("Aun no hay platillos registrados");
        }


        //Codigo para leer archivo de restaurantes
        try (BufferedReader reader = new BufferedReader(new FileReader("restaurantes.txt"))) {
            ArrayList<String> rest = new ArrayList<>(3);
            String line;
            while ((line = reader.readLine()) != null) {
                rest.add(line);
            }
            if (!rest.isEmpty()) {
                restaurante = new Restaurante(rest.get(0), rest.get(1), Double.parseDouble(rest.get(2)), new ArrayList<Pedido>(), new ArrayList<Receta>());
                pedidoListView1.setItems(FXCollections.observableArrayList(restaurante.getRecetas()));

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        this.list = FXCollections.observableArrayList(restaurante.getRecetas());


        //Se inicializan los valores para la listView
        ObservableList<Receta> list = FXCollections.observableArrayList(restaurante.getRecetas());
        this.pedidoListView1.setItems(list);


        //Codigo para leer archivo de Clientes

        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"))) {
            ArrayList<String> rest = new ArrayList<>(3);
            String line;
            String[] output = new String[100];
            while ((line = reader.readLine()) != null) {
                output = line.split(",");
                Cliente cliente = new Cliente(output[0], output[1], output[2]);
                cliente.setTelefono(output[3]);
                if (restaurante != null) {

                    restaurante.addCliente(cliente);
                }
                clientes.put(cliente.getTelefono(), cliente);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        //Codigo para leer repartidores


        try (BufferedReader reader = new BufferedReader(new FileReader("repartidores.txt"))) {
            ArrayList<String> rest = new ArrayList<>(4);
            String line;
            String[] output = new String[100];
            while ((line = reader.readLine()) != null) {
                output = line.split(",");


                Repartidor repartidor = new Repartidor(output[0], output[1], Double.parseDouble(output[2]), Double.parseDouble((output[3])));

                repartidores.add(repartidor);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        if (restaurante != null) {

            //Codigo para leer archivo de recetas
            try (BufferedReader reader = new BufferedReader(new FileReader("recetas.txt"))) {
                ArrayList<String> recetas = new ArrayList<>(5);

                String line;
                String[] output = new String[100];
                while ((line = reader.readLine()) != null) {
                    Receta receta;
                    output = line.split(",");
                    if (output[0].charAt(0) == 'c') {
                        System.out.println("true");
                        receta = new Comida(Double.parseDouble(output[1]), output[2], output[3]);
                    } else if (output[0].charAt(0) == 'b') {
                        boolean state;
                        if (output[2] == "T") {
                            state = true;
                        } else {
                            state = false;
                        }
                        receta = new Bebida(output[1], state, Double.parseDouble(output[3]), Double.parseDouble(output[4]));

                    } else {
                        receta = new Postre(output[1], output[2], Integer.parseInt(output[3]), Double.parseDouble(output[4]));


                    }

                    restaurante.agregarReceta(receta);


                }
            } catch (IOException e) {
                e.printStackTrace();

            }
            System.out.println(restaurante.getPedidos());
        }
    }
    }


