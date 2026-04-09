# API endpoints provided by the Spring Boot backend

The URL of the backend will be represented by the keyword b_url
The API will be available after the /api/ endpoint

## Weather API  

### Source

InSight: Mars Weather Service API
Data will be collected by the backend every day at fixed
time and stored in the DB 

`b_url/api/weather` - base of the url

### Exposed endpoints
- `GET b_url/api/weather/latest` - returns the latest saved weather measurement
- `GET b_url/api/weather/avg/{:day_id}` - returns the avg of the measured values in a gien day (the values will be calculated by the end of the day and all the measurements for the day are dropped)



## Rover API

### Source

**Rover daily position** - https://science.nasa.gov/mission/mars-2020-perseverance/location-map/
> [!NOTE]
> The rover API was removed, so the daily position will be provided manually to the db

`b_url/api/rover` - base of the url

### Exposed endpoints
- `GET b_url/api/rover/position_latest` - returns latest position of the rover

## Map API

### Source
**Mars Map** - Vesta/Moon/Mars Trek WMTS

> [!NOTE]
> `TODO:`
> Figure out a way to send the tiles around the current map position

## News API

### Source

`b_url/api/news` - base of the url
**Mars related news details and links** - Spaceflight News API

### Exposed endpoints

-  `GET b_url/api/news/{:day_id}` - returns the news from the given day 

## Image API

