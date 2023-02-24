@SAP 
Feature: SAPDemo 


@WebOTC @SAPFIORI 
Scenario: TC_01_OrderToCash 
	Given I have login into SAP Fiori 
	And I create sales order 
		| OrderType | Salesorg | Distriction | Division | Soldtoparty | Shiptoparty | CustRef  | Material | Quantity | 
		| OR        | 1710     | 10          | 00       | EWM17-CU01  | EWM17-CU01  | REF1456U | EWMS4-01 | 1        | 
	And I create a outbound delivery 
		| Shipping | PickedQuan | 
		| 1710     | 1          | 
	When I change the mode of outbound delivery 
	Then I should see Billing document is saved successfully 
	
@OTC @SAPGUI 
Scenario: TC_02_OrderToCash 
	Given I am on the SAP application 
	And I create sales order 
		| OrderType | Salesorg | Distriction | Division | Soldtoparty | Shiptoparty | CustRef  | Material | Quantity | 
		| OR        | 1710     | 10          | 00       | EWM17-CU01  | EWM17-CU01  | REF1456U | EWMS4-01 | 1        | 
	And I create a outbound delivery 
		| Shipping | PickedQuan | 
		| 1710     | 1          | 
	When I change the mode of outbound delivery 
	Then I should see Billing document is saved successfully 
	
@OTP @SAPGUI 
Scenario: TC_03_OrderToPay 
	Given I am on the SAP application 
	And I create purchase requisition 
		| Material | Quantity | Plnt | StoreLocation |
		| 92       |      6| 1710 | 171A          | 
	And I create purchase order 
		| Vendor  | PurchaseOrg | PurchaseGroup | CompanyCode | Material | Quantity | DelivDate  | NetPrice | Plnt | StoreLocation | 
		| 1000150 | 1710        | 001           | 1710        | 92       |6    |12/07/2020 | 94.81    | 1710 | 171A          | 
	When I create the goods receipt 
	Then I should see invoice document is posted successfully 
		| InvoiceDate | CustRef    | 
		| 12/02/2020| Cusk289 | 