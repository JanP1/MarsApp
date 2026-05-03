# Application planning

The mars app is a project aimed at creating a website that will update the user on informations
about the planet Mars.

## Tech stack

- **Angular** - for the frontend
- **Spring Boot** - for the backend
- **PostgreSQL** - for the DB

## Data source

Data will be collected from the NASA public API.



## Funcionality and Appaerence

### Main topics that will be available
- Mars weather
- Mars rover updates
- Mars rover position on Map if possible


### Map functionality
Previously the map was going to fetch points for a path if the zoom is greater less than 10, otherwise 
it was fetching all the points in the visible bbox

The change should be that every morning it should be checked if a new point is added
after the check there should be a calculation of most significant points for every zoom level

Then in a column called "min_zoom" we store the value


The frontend fetches in the bbox, and next it searches which of the selected rows have
`min_zoom` less or equal to the provided zoom

### Weather funcionality

The weather for the last sol should be displayed on main screen
A chart of previous should be displayed on /weather
