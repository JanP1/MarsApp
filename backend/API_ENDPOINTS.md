# API endpoints provided by the Spring Boot backend

The URL of the backend will be represented by the keyword b_url
The API will be available after the /api/ endpoint

## Weather API  
**Source** - InSight: Mars Weather Service API
Data will be collected by the backend every day at fixed
time and stored in the DB 

`b_url/api/weather` - base of the url

### Exposed endpoints
- `GET b_url/api/weather/latest` - returns the latest saved weather measurement
- `GET b_url/api/weather/avg/{:day_id}` - returns the avg of the measured values in a gien day (the values will be calculated by the end of the day and all the measurements for the day are dropped)



## Rover API

## News API

## Image API

