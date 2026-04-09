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
- `GET b_url/api/weather/{:day_id}` - returns the value measured in a given day


`GET b_url/api/weather/latest` and `GET b_url/api/weather/{:day_id}`

Response example:

```js
[ 
    {
        sol: 4856,
        high: -2,
        low: -69,
    },
]

```


## Rover API

### Source

**Rover daily position** - https://science.nasa.gov/mission/mars-2020-perseverance/location-map/
> [!NOTE]
> The rover API was removed, so the daily position will be provided manually to the db

`b_url/api/rover` - base of the url

### Exposed endpoints
- `GET b_url/api/rover/position_latest` - returns the latest position of the rover


Response example:

```js
[ 
    {
        sol: 4856,
        high: -2,
        low: -69,
    },
]

```


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




> [!NOTE]
> The API provided is mostly outdated or archived and no longer available so
> probably the project will be extended to Earth as well
