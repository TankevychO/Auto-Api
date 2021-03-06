#  🚗 **Auto service**
The application implements a service for working with a database of stolen autos. </br>
###### Available actions of the application:
The application has the ability:
1. Adding a car to the database. To write to the database, the user enters the name, state number, color and VIN code (which is programmatically decoded into the make, model and year, everything is written to the database for storage), validation of the entered values. </br>
2. Displaying a list of stolen cars from: </br>
  - pagination; </br>
  - sorting by all fields; </br>
  - search by name / license plate / VIN code; </br>
  - filters by manufacturer, model, year; </br>
3. Editing and deleting records </br>
4. Export of the list to an XLS file </br>

5. Auto-update of the database of brands and models once a month. </br>
6. Autocomplete for a manufacturer and output all models of this manufacturer. </br>
 
###### All controllers:
>GET: /autos </br>

Get a list of autos with pagination, filtering and sorting. </br>
#### Params:
- *count* - number of lines per page </br>
- *page* - current page number </br>
- *sortBy* - sort option (all fields) </br>
- *year* - filtering by year </br>
- *manufacturer* - filtering by manufacturer </br>
- *model* - filtering by model </br>
> POST: /autos - add auto </br>

> GET: /autos/by-vin - get auto by VIN code </br>

> GET: /autos/by-name - get auto by owner's name </br>

> GET: /autos/by-number - get auto by number </br>

 > GET: /autos/export - export list to an XLS file. </br>

> PUT: /autos/{id} - change auto by id </br>

> DELETE: /autos/{id} - delete auto by id </br>

> GET: /inject - upload data to DB </br>

> GET: /manufacturers/search - autocomplete for a brand and get all models of this manufacturer </br>

> GET: /models/by-manufacturer?manufacturer - get list all models by manufacturer </br>
________________________________________________________________________________________________________________________
###### Technologies:
- Spring Boot, Spring Data
- Hibernate
- MySQL
- Maven
_______________________________________________________________________________________________________________________
###### Implementation details and technologies
Project based on 3-layer architecture.</br>
To implement the application were created: database, models, dto, interfaces and services for each model, controllers for all actions.
_______________________________________________________________________________________________________________________
###### Setup "Auto service"
- [x] Install MySQL and MySQL Workbench </br>
- [x] Add plugin Lombok </br>
- [x] Create DB in the Workbench </br>
- [x] Upload data to DB `GET: /inject` </br>
- [x] Change `DRIVER`, `DIALECT`, `URL`, `USER`, `PASSWORD` in `/resources/application.properties` </br>
