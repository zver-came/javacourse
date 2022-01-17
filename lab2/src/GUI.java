import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GUI extends JDialog implements ReadWrite{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton exitButton;
    private JTextField passengerName;
    private JTextField passengerSurname;
    private JRadioButton RadioTaxi;
    private JRadioButton RadioBus;
    private JRadioButton RadioPoliceCar;
    private JRadioButton RadioFireCar;
    private JList PassengersList;
    private JList vehiclesList;
    private JList roadsList;
    private JButton writeButton;
    private JButton readButton;
    private JButton passengerCreate;
    private JButton policemanCreate;
    private JButton firemanCreate;
    private JList policemanRankList;
    private JList firemanRankList;
    private JButton vehicleCreate;
    private JButton roadCreate;
    private JLabel firemanRank;
    private JLabel policemanRank;
    private JButton addCar;
    private JButton addPassengerToCar;
    private JButton removePassenger;
    private JLabel roadSelect;
    private JLabel vehicleSelect;
    private JLabel mesg;

    private List<Passenger> passengers;
    private List<Road> roads;
    private List<Vehicle> vehicles;
    Object policementRankf, firemanRankf;
    public GUI() {
        passengers = new ArrayList<>();
        roads = new ArrayList<>();
        vehicles = new ArrayList<>();

        printRoads();
        printVehicle();
        RadioSelect();
        addCarEnabled();
        addPassengertoCar();
        PassengerWrite();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        NameSurnameInput();

        firemanRankList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(firemanRankList.getSelectedIndex() != -1){
                    firemanRank.setText("Обрано: "+firemanRankList.getSelectedValue());
                    firemanRankf = firemanRankList.getSelectedValue();
                    printPolicemanRankList();
                    if(passengerCreate.isEnabled()) firemanCreate.setEnabled(true);
                }
                else firemanCreate.setEnabled(false);
            }
        });
        policemanRankList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(policemanRankList.getSelectedIndex() != -1){
                    policemanRank.setText("Обрано: "+policemanRankList.getSelectedValue());
                    policementRankf = policemanRankList.getSelectedValue();
                    printFiremanRankList();
                    if(passengerCreate.isEnabled()) policemanCreate.setEnabled(true);
                }
                else policemanCreate.setEnabled(false);
            }
        });
        passengerName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NameSurnameInput();
                System.out.println(passengerName.getText());
            }
        });
        passengerSurname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NameSurnameInput();
                System.out.println(passengerName.getText());
            }
        });

        //Create Passenger
        passengerCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String [] text = NameSurnameInput();
                if( passengerCreate.isEnabled()){
                    passengerName.setText("");
                    passengerSurname.setText("");
                    passengerCreate.setEnabled(false);
                    passengers.add(new Passenger(text[0], text[1]));
                    printPassenger();
                }
            }
        });
        policemanCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String [] text = NameSurnameInput();
                if( passengerCreate.isEnabled() && policementRankf != ""){
                    passengerName.setText("");
                    passengerSurname.setText("");
                    passengers.add(new Policeman(text[0], text[1], PolicemanRank.valueOf(policementRankf.toString())));
                    printPassenger();
                }
            }
        });
        firemanCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String [] text = NameSurnameInput();
                if( passengerCreate.isEnabled() && firemanRankf != ""){
                    passengerName.setText("");
                    passengerSurname.setText("");
                    passengers.add(new Fireman(text[0], text[1], FiremanRank.valueOf(firemanRankf.toString())));
                    printPassenger();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        //Create Road
        roadsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(roadsList.getSelectedIndex()!=-1){
                    addCarEnabled();
                    System.out.println(roadsList.getSelectedValue());
                    roadSelect.setText("Обрано: "+ roadsList.getSelectedValue());
                }
            }
        });
        roadCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roads.add(new Road());
                printRoads();
            }
        });

        //Create Vehicle
        RadioBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RadioSelect();
                RadioTaxi.setSelected(false);
                RadioPoliceCar.setSelected(false);
                RadioFireCar.setSelected(false);
            }
        });
        RadioTaxi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RadioSelect();
                RadioBus.setSelected(false);
                RadioPoliceCar.setSelected(false);
                RadioFireCar.setSelected(false);
            }
        });
        RadioPoliceCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RadioSelect();
                RadioTaxi.setSelected(false);
                RadioBus.setSelected(false);
                RadioFireCar.setSelected(false);
            }
        });
        RadioFireCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RadioSelect();
                RadioTaxi.setSelected(false);
                RadioBus.setSelected(false);
                RadioPoliceCar.setSelected(false);
            }
        });
        vehicleCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RadioTaxi.isSelected()){
                    RadioTaxi.setSelected(false);
                    vehicles.add(new Taxi());
                }
                else if(RadioBus.isSelected()){
                    RadioBus.setSelected(false);
                    vehicles.add(new Bus());
                }
                else if(RadioFireCar.isSelected()){
                    RadioFireCar.setSelected(false);
                    vehicles.add(new FireTruck());
                }
                else if(RadioPoliceCar.isSelected()){
                    RadioPoliceCar.setSelected(false);
                    vehicles.add(new PoliceCar());
                }
                printVehicle();
                RadioSelect();
            }
        });

        //Add passenger to car
        PassengersList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                addPassengertoCar();
                PassengerWrite();
            }
        });
        vehiclesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                addPassengertoCar();
            }
        });
        addPassengerToCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addPassengerToCar.isEnabled()){
                    int index = vehicles.indexOf(vehiclesList.getSelectedValue());
                    try {
                        System.out.println(vehicles.get(index).getClass());
                        Object pass = PassengersList.getSelectedValue();
                        if(pass.getClass().equals((new Policeman("1", "2", PolicemanRank.Captain)).getClass())) vehicles.get(index).boarding((Policeman) pass);
                        else if(pass.getClass().equals((new Fireman("1", "2", FiremanRank.Middle)).getClass())) vehicles.get(index).boarding((Fireman) pass);
                        else vehicles.get(index).boarding((Passenger) pass);
                        printVehicle();
                    } catch (Exception ex) {
                        mesg.setText(ex.getMessage());
                    }
                }
            }
        });
        removePassenger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(removePassenger.isEnabled()){
                    int index = vehicles.indexOf(vehiclesList.getSelectedValue());
                    try {
                        vehicles.get(index).landing((Passenger) PassengersList.getSelectedValue());
                        printVehicle();
                    } catch (Exception ex) {
                        mesg.setText(ex.getMessage());
                    }
                }
            }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("read");
                try {
                    passengers = read();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("write");
                try {
                    write((Passenger) PassengersList.getSelectedValue());
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    private void printRoads(){
        roadsList.setSelectedIndex(-1);
        roadSelect.setText("Обрано: ");
        roadsList.setListData(new Vector<Road>(roads));
    }
    private void printVehicle(){
        vehiclesList.setSelectedIndex(-1);
        vehicleSelect.setText("Обрано: ");
        vehiclesList.setListData(new Vector<Vehicle>(vehicles));
    }
    private void addCarEnabled(){
        if(vehiclesList.getSelectedIndex()!=-1 && roadsList.getSelectedIndex()!=-1) addCar.setEnabled(true);
        else addCar.setEnabled(false);
    }
    private void PassengerWrite(){
        if(PassengersList.getSelectedIndex()!=-1) writeButton.setEnabled(true);
        else writeButton.setEnabled(false);
    }
    private void addPassengertoCar(){
        if(PassengersList.getSelectedIndex()!=-1 && vehiclesList.getSelectedIndex()!=-1){
            addPassengerToCar.setEnabled(true);
            removePassenger.setEnabled(true);
        }
        else {
            addPassengerToCar.setEnabled(false);
            removePassenger.setEnabled(false);
        }
    }
    private void RadioSelect(){
        if(RadioBus.isSelected() || RadioTaxi.isSelected() || RadioFireCar.isSelected() || RadioPoliceCar.isSelected()){
            vehicleCreate.setEnabled(true);
        }
        else vehicleCreate.setEnabled(false);
    }
    private void printPassenger(){
        PassengersList.setListData(new Vector<Passenger>(passengers) );
        printPolicemanRankList();
        printFiremanRankList();
    }
    private void printPolicemanRankList(){
        policemanRankList.setSelectedIndex(-1);
        policemanRank.setText("Не обрано звання");
        policemanRankList.setListData(PolicemanRank.values());
        policemanCreate.setEnabled(false);
    }
    private void printFiremanRankList(){
        firemanRankList.setSelectedIndex(-1);
        firemanRank.setText("Не обрано звання");
        firemanRankList.setListData(FiremanRank.values());
        firemanCreate.setEnabled(false);
    }

    private String[] NameSurnameInput(){
        String [] text = new String[2];
        text[0] = passengerName.getText().trim();
        text[1]= passengerSurname.getText().trim();
        printPassenger();
        if( text[0].length() != 0 && text[1].length() != 0){
            passengerCreate.setEnabled(true);
            return text;
        }
        else passengerCreate.setEnabled(false);
        return null;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {

        GUI dialog = new GUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
