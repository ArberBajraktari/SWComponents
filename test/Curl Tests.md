## /parcel (POST)
curl -X POST "http://localhost:8080/parcel" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"recipient\":{\"city\":\"string\",\"country\":\"string\",\"name\":\"string\",\"postalCode\":\"string\",\"street\":\"string\"},\"sender\":{\"city\":\"string\",\"country\":\"string\",\"name\":\"string\",\"postalCode\":\"string\",\"street\":\"string\"},\"weight\":0}"

## /parcel/{trackingID} (GET)
curl -X GET "http://localhost:8080/parcel/PYJRB4HZ6" -H "accept: application/json"

## /warehouse (GET)
curl -X GET "http://localhost:8080/warehouse" -H "accept: application/json"

## /warehouse (POST)
curl -X POST "http://localhost:8080/warehouse" -H "accept: */*" -H "Content-Type: application/json" -d "{\"code\":\"string\",\"description\":\"string\",\"hopType\":\"string\",\"level\":0,\"locationCoordinates\":{\"lat\":0,\"lon\":0},\"locationName\":\"string\",\"nextHops\":[{\"hop\":{\"code\":\"string\",\"description\":\"string\",\"hopType\":\"string\",\"locationCoordinates\":{\"lat\":0,\"lon\":0},\"locationName\":\"string\",\"processingDelayMins\":0},\"traveltimeMins\":0}],\"processingDelayMins\":0}"