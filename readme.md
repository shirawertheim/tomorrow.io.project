# Tomorrow.io API task


## Overview
The following repo contains examples for tomorrow.io Java API.
This API allows users to check for specific weather conditions within the next 72 hours, based on data from the tomorrow.io/timeline API. 
The API allows users to specify the weather conditions in the form of comparison statements, indicating how the conditions should be evaluated. 
The API returns a timeline that displays whether the specified conditions are expected to occur in the next 72 hours.


## Guidelines
An example of legal GET request:

[GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,wind<10,visibility>4&operator=OR
]()

### Stick to the following format:

#### prefix
- GET/weather-conditions

#### location 
- polyline location

#### rule
String of conditions separated with ",". Condition is build from 3 part:
1.  **Condition**
     - humidity
     - windSpeed
     - rainIntensity
    - temperature


2. **Operator**
   - '>'
   - '<'
  
3. **Value**
   - integer

** notice: If there is illegal input of problem in the service, the program will through an exception (400/403/500).

** If you would like to change one of the properties, you can do it through the application.properties located in resources.


### Response

A proper response should be in the following format:


`{"status": "success","data":{"timelines":[{"startTime":"2023-02-07T00:00:00Z","endTime":"2023-02-10T05:00","condition_met":false},{"startTime":"2023-02-07T05:00:00Z","endTime":"2023-02-10T18:00","condition_met":true},{"startTime":"2023-02-07T18:00:00Z","endTime":"2023-02-10T19:00","condition_met":false},{"startTime":"2023-02-07T19:00:00Z","endTime":"2023-02-10T20:00","condition_met":true},{"startTime":"2023-02-07T20:00:00Z","endTime":"2023-02-11T03:00","condition_met":false},{"startTime":"2023-02-08T03:00:00Z","endTime":"2023-02-11T13:00","condition_met":true},{"startTime":"2023-02-08T13:00:00Z","endTime":"2023-02-11T22:00","condition_met":false},{"startTime":"2023-02-08T22:00:00Z","endTime":"2023-02-12T20:00","condition_met":true},{"startTime":"2023-02-09T20:00:00Z","endTime":"2023-02-13T03:00","condition_met":false},{"startTime":"2023-02-10T03:00:00Z","endTime":"2023-02-13T06:00","condition_met":true},{"startTime":"2023-02-10T06:00:00Z","endTime":"2023-02-13T21:00","condition_met":false}]}}`