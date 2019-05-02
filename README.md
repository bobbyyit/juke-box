# Jukebox finder

Given a jukebox setting id, returns elegible jukeboxes

How to start application
Run Jukebox.main() and navigate to http://localhost:8080/status to verify if the application is up and running

## Enpoints

```sh
GET: jukeboxes
Parameters
setting-id (Mandatory): the setting id
model: filter model 
limit: specifies the page size
offest: specifies at what index start the page
```

### Sample Response:
```
[{"id":"5ca94a8ab592da6c6f2d562e",
"model":"fusion",
"components":[{"name":"money_receiver"},
{"name":"money_storage"}]}]
```

## Error Messages
```
1: Could not find setting
2: Could not find jukebox
3:You are up and running
```

### Sample Response
```
{"code":1,"message":"Could not find setting"}
```