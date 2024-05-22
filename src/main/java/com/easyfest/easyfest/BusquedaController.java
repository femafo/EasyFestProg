package com.easyfest.easyfest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.function.Predicate;

public class BusquedaController {
    public TableView<Customer> tblCustomer;
    public TableColumn colCustID;
    public TableColumn colDOB;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colCustName;
    public TextField txtSearchBar;
    //now we should create observerable array list
    final ObservableList<Customer> custList= FXCollections.observableArrayList();
    public  void initialize(){
        //Initialize column like this
        setCustomer();
        colCustID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));

        //now we should create a model Customer ok
        //now we should add sample Data to custList
        //i am create setCustomer() method like this
        //ok we should add customers to our table like this
        tblCustomer.setItems(custList);//ok done
        //ok we can create filter search
        //create searchFilter method
        searchFilter();




    }

    private void searchFilter() {
        FilteredList<Customer> filterData= new FilteredList<>(custList,e->true);
        txtSearchBar.setOnKeyReleased(e->{


            txtSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
                filterData.setPredicate((Predicate<? super Customer >) cust->{
                    if(newValue==null){
                        return true;
                    }
                    String toLowerCaseFilter = newValue.toLowerCase();
                    if(cust.getId().contains(newValue)){
                        return true;
                    }else  if(cust.getAddress().toLowerCase().contains(toLowerCaseFilter)){
                        return true;
                    }else  if(cust.getCity().toLowerCase().contains(toLowerCaseFilter)){
                        return true;
                    }else  if(cust.getDob().toLowerCase().contains(toLowerCaseFilter)){
                        return true;
                    }else  if(cust.getName().toLowerCase().contains(toLowerCaseFilter)){
                        return true;
                    }

                    return false;
                });
            });

            final SortedList<Customer> customers = new SortedList<>(filterData);
            customers.comparatorProperty().bind(tblCustomer.comparatorProperty());
            tblCustomer.setItems(customers);
            //ok let's check it
        });

    }

    private void setCustomer() {
        //now we can add some data to table like this
        //i am created previously some example data  so i will add like this

        custList.add(new Customer ("C001","Danapala","1981-2-6","No.20 Walana","Panadura"));
        custList.add(new Customer ("C002","Gunapala","1982-8-12","No 200, Thalpitiya","Wadduwa"));
        custList.add(new Customer ("C003","Amarapala","1988-1-2","No 100, Horawala","Matugama"));
        custList.add(new Customer ("C004","Somapala","1952-1-2","No .10, Ginigama","Galle"));
        custList.add(new Customer ("C005","Jinapala","1974-1-8","N0. 34 Ginthota","Aluthgama"));
        custList.add(new Customer ("C006","Gnanawathee","1982-1-3","No56,230, Galle Road","Panadura"));
        custList.add(new Customer ("C007","Amarawathee","1984-5-7","No34,Galle Road","Ambalangoda"));
        custList.add(new Customer ("C008","Leelawathee","1950-4-8","No 12,Rathnapura Road","Madampe"));
        custList.add(new Customer ("C009","Gunawathee","1972-3-9","No122,Anuradhapura Road","Kurunegala"));
        custList.add( new Customer ("C010","Dayapala","1983-4-9","No. 234,Attidiya Road","Dehiwala"));
        custList.add(new Customer ("C011","Sangapala","1990-5-9","No.43,St Peters Road","Negambo"));
        custList.add(new Customer ("C012","Ariyawathee","1987-8-9","No. 123, Pamunuwa Road","Maharagama"));
        custList.add(new Customer ("C013","Somawathee","1987-5-3","No. 345, Matugama Road","Kalutara"));
        //ok now we can view table like this
    }



}
