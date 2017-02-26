/**
@author: Sushil Verma
@version: 1.0
@date: 25/02/2017
@Description: Careem Smart Transpotation chaincode
@Team:	EaseItUp
@
**/

package main

import (
	"errors"
	"fmt"
	"strconv"
	"github.com/hyperledger/fabric/core/chaincode/shim"
)

// Careem Smart Transport Chaincode implementation
type CareemSmartTransportChaincode struct {
}

type Customer struct {
	id 		string 		'json:"id"'
	firstName	string 		'json:"firstName"'
	lastName	string 		'json:"lastName"'
}

type TransportRoute struct {
	fromX 		string `json:"fromX"`
	fromY 		string `json:"fromY"`
	toX 		string `json:"toX"`
	toY 		string `json:"toY"`
}

type TransportPackage struct {
    id 				string `json:"id"`
    name 			string `json:"name"`
    shape 			string `json:"shape"`
    weight 			string `json:"weight"`
    contentType 		string `json:"contentType"`
    qty 			int `json:"qty"`
    datePickup 			string `json:"datePickup"`
    dateDelivered 		string `json:"dateDelivered"`
    TransportRoute 		TransportRoute `json:"transportRoute"`
}

type Order struct {
	id 			string 				`json:"id"`
	customer 		Customer 			`json:"customer"`
	transportPackage 	[]TransportPackage 		`json:"transportPackage"`
	status			string 				`json:"status"`
}

func (t *CareemSmartTransportChaincode) Init(	stub shim.ChaincodeStubInterface, 
								function string, 
								args []string) ([]byte, error) {
	fmt.Println("Init firing. Function will be ignored: " + function)	
	// Initialize the collection of commercial paper keys
	fmt.Println("Initialization complete")
	return nil, nil
}

// Invoke Careem APIs
func (t *CareemSmartTransportChaincode) Invoke(	stub shim.ChaincodeStubInterface, 
						function string, 
						args []string) ([]byte, error) {
	fmt.Println("Invoke running. Function: " + function)
	fmt.Printf("args: %s\n", args[1])

	if function == "addCustomer" {
		return t.addCustomer(stub, args)
	} else if function == "addOrder" {
		return t.addOrder(stub, args)
	} else if function == "updateOrder" {
		return t.updateOrder(stub, args)
	}

}

// Deletes an entity from state
func (t *CareemSmartTransportChaincode) delete(	stub shim.ChaincodeStubInterface, 
						args []string) ([]byte, error) {
	fmt.Println("Entering into function: " + function)
	//TODO implement delete
	fmt.Println("Exiting from function: " + function)
}

// Query callback representing the query of a chaincode
func (t *CareemSmartTransportChaincode) Query(	stub shim.ChaincodeStubInterface, 
						function string, 
						args []string) ([]byte, error) {
	fmt.Println("Entering into function: " + function)
	//TODO implement Query
	fmt.Println("Exiting from function: " + function)
}


//Careem Smart Transport APIs

func (t *CareemSmartTransportChaincode) addCustomer(stub shim.ChaincodeStubInterface, 
							customerJson string) ([]byte, error) {
	fmt.Println("Entering into function: " + function)	
	fmt.Printf("Customer Json object: %v\n", customerJson)
	//TODO implement addCustomer
	fmt.Println("Exiting from function: " + function)
}

func (t *CareemSmartTransportChaincode) addOrder(stub shim.ChaincodeStubInterface, 
							orderJson string) ([]byte, error) {
	fmt.Println("Entering into function: " + function)
	fmt.Printf("Order Json object: %v\n", addOrder)
	//TODO implement addOrder
	fmt.Println("Exiting from function: " + function)
}

func (t *CareemSmartTransportChaincode) updateOrder(stub shim.ChaincodeStubInterface, 
							orderJson string) ([]byte, error) {
	fmt.Println("Entering into function: " + function)
	fmt.Printf("Order Json object: %v\n", addOrder)
	//TODO implement updateOrder
	fmt.Println("Exiting from function: " + function)
}

func main() {
	err := shim.Start(new(CareemSmartTransportChaincode))
	if err != nil {
		fmt.Printf("***** Error starting Simple chaincode: %s", err)
	}
}
