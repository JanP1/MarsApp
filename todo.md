# To Do

## General app planning
- [ ] Plan the functionality of the app


## Parts

### Weather functionality

x Consume the weather API via a scheduled job - *apparently the API is outdated*
- [ ] Create a REST endpoint for reading weather information - the data is going to be provided manually to the DB
- [ ] Graph representing weather change over time

### Rover functionality

x Rover photos check every hour - *API removed*
- [ ] Rover position every hour - for the sake of the project they will be provided manually (no public API)
- [ ] Exposing the information via a REST api and a local S3 bucket
- [ ] Getting map tiles for the approximate surrounding of the rovers
- [ ] Generating a map and path based on the location of the rovers

### News functionality


- [ ] Creating a job getting Mars related news from the SpacecraftNews API
- [ ] News View + News bubble floating

