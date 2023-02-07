# Tomorrow.io API task


## Overview
This repository contains examples for the tomorrow.io Java API. 
This API allows users to check for specific weather conditions in the next 72 hours based on data from the tomorrow.io/timeline API. 
The API returns a timeline that displays the expected weather conditions in the next 72 hours based on the comparison statements specified by the user.

## Usage
- To run the project, open it in an IDE such as IntelliJ and create a project. 
- You can send API requests using tools such as Postman or by sending a GET request to 'http://localhost:8080' in your browser.


## API Guidelines

An example of a valid API request is:


[weather-conditions?location=40.7,-73.9&rule=temperature>30,wind<10,visibility>4&operator=OR
]()

### Request format

The API request should have the following format:

#### prefix
- 'GET/weather-conditions'

#### location
- Polyline location, e.g. '40.7,-73.9'

#### rule
A string of conditions separated by ",". Each rule has three parts:

1.  **Condition**
    At least one of the following:
    - humidity
    - windSpeed
    - rainIntensity
    - temperature


2. **Operator**
   - either '>' or '<'

3. **Value**
    - an integer

### Note:

- If there is an illegal input or problem with the service, the program will throw an exception with a 400/404/500 status code.

- You can change the properties in the API request through the application.properties file located in the 'resources' directory.

- The received data may include time intervals that are have passed already. My current program does not compare the current real time with the interval received time and therefore may return a result time frame that has already passed.

### Response format
 
A proper API response should be in the following format:

`{
"status": "success",
"data": {
"timelines": [
{
"startTime": "2023-02-07T16:00:00Z",
"endTime": "2023-02-07T17:00:00Z",
"condition_met": false
},
{
"startTime": "2023-02-07T17:00:00Z",
"endTime": "2023-02-07T23:00:00Z",
"condition_met": true
},
{
"startTime": "2023-02-07T23:00:00Z",
"endTime": "2023-02-08T02:00:00Z",
"condition_met": false
},
{
"startTime": "2023-02-08T02:00:00Z",
"endTime": "2023-02-08T03:00:00Z",
"condition_met": true
},
{
"startTime": "2023-02-08T03:00:00Z",
"endTime": "2023-02-08T13:00:00Z",
"condition_met": false
},
{
"startTime": "2023-02-08T13:00:00Z",
"endTime": "2023-02-08T22:00:00Z",
"condition_met": true
},
{
"startTime": "2023-02-08T22:00:00Z",
"endTime": "2023-02-09T21:00:00Z",
"condition_met": false
},
{
"startTime": "2023-02-09T21:00:00Z",
"endTime": "2023-02-10T16:00:00Z",
"condition_met": true
}
]
}
}
`

